package com.example.webfluxllm.chapter2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicFluxOperatorTest {

    /**
     * Flux
     * 데이터 : just, empty, from~시리즈
     * 함수 : defer, create
     */
    @Test
    public void testFluxFromData() {
        Flux.just(1,2,3,4)
                .subscribe(data -> System.out.println("data = " + data));

        List<Integer> basicList = List.of(1, 2, 3, 4);
        Flux.fromIterable(basicList)
                .subscribe(data -> System.out.println("data fromIterable= " + data));
    }

    /**
     * Flux defer -> 안에서 Flux객체를 반환해줘야 합니다.
     * Flux create -> 안에서 동기적인 객체를 반환해줘야 합니다.
     */
    @Test
    public void testFluxFromFunction() {
        Flux.defer(() -> {
            return Flux.just(1, 2, 3, 4);
        }).subscribe(data -> System.out.println("data from defer = " + data));

        Flux.create(sink -> {
            sink.next(1);
            sink.next(2);
            sink.next(3);
            sink.complete();
        }).subscribe(data -> System.out.println("data from sink = " + data));
    }

    @Test
    public void testSinkDetail() {
        Flux.<String>create(sink -> {
            AtomicInteger counter = new AtomicInteger(0);
            recursiveFunction(sink);
        })
                .contextWrite(Context.of("counter", new AtomicInteger(0)))
                .subscribe(data -> System.out.println("data from recursive = " + data));
    }

    public void recursiveFunction(FluxSink<String> sink) {
        AtomicInteger counter = sink.contextView().get("counter");
        if (counter.incrementAndGet() < 10) {
            sink.next("sink count " + counter);
            recursiveFunction(sink);
        } else {
            sink.complete();
        }
    }

    //ThreadLocal -> context 대신 사용

    /*
    Flux의 흐름 시작 방법
    1. 데이터로 부터 : just, empty, from 시리즈
    2. 함수로 부터 : defer (Flux객체를 return), create (동기적인 객체를 return - next)
     */

    @Test
    public void testFluxCollectList() {
        Mono<List<Integer>> listMono = Flux.<Integer>just(1, 2, 3, 4, 5)
                .map(data -> data * 2)
                .filter(data -> data % 4 == 0)
                .collectList();

        listMono.subscribe(data -> System.out.println("collectList가 변환한 List data! = " + data));
    }
    /*
    Mono -> Flux 변환 flatMapMany
    Flux -> Mono변환 collectList
     */

}
