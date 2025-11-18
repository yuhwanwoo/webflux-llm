package com.example.webfluxllm.chapter2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class OperatorFlatMapTest {
    /*
    Mono<Mono<T>> -> Mono<T>
    Mono<Flux<T>> -> Flux<T>
    Flux<Mono<T>> -> Flux<T>
     */

    @Test
    public void monoToFlux() {
        Mono<Integer> one = Mono.just(1);
        Flux<Integer> integerFlux = one.flatMapMany(data -> {
            return Flux.just(data, data + 1, data + 2);
        });
        integerFlux.subscribe(data -> System.out.println("data = " + data));
    }

    @Test
    public void testWebClientFlatMap() {
        Flux<String> flatMap = Flux.just(callWebClient("1단계 - 문제 이해하기", 1500),
                        callWebClient("2단계 - 문제 단계별로 풀어가기", 1000),
                        callWebClient("3단계 - 최종 응답", 500))
                .flatMap(monoData -> {
                    return monoData;
                });

        flatMap.subscribe(data -> System.out.println("FlatMapped data = " + data));

        Flux<String> flatMapSequential = Flux.just(callWebClient("1단계 - 문제 이해하기", 1500),
                        callWebClient("2단계 - 문제 단계별로 풀어가기", 1000),
                        callWebClient("3단계 - 최종 응답", 500))
                .flatMapSequential(monoData -> {
                    return monoData;
                });

        flatMapSequential.subscribe(data -> System.out.println("FlatMapped Sequential data = " + data));

        Flux<String> merge = Flux.merge(callWebClient("1단계 - 문제 이해하기", 1500),
                        callWebClient("2단계 - 문제 단계별로 풀어가기", 1000),
                        callWebClient("3단계 - 최종 응답", 500));

        merge.subscribe(data -> System.out.println("FlatMapped merge data = " + data));

        Flux<String> mergeSequential = Flux.mergeSequential(callWebClient("1단계 - 문제 이해하기", 1500),
                callWebClient("2단계 - 문제 단계별로 풀어가기", 1000),
                callWebClient("3단계 - 최종 응답", 500));

        mergeSequential.subscribe(data -> System.out.println("FlatMapped mergeSequential data = " + data));

        Mono<String> monomonoString = Mono.just(Mono.just("안녕!")).flatMap(monoData -> monoData);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
    }
    //concat, concatMap 이런거 쓰지 말자
    /*
    Flux<Mono<T>>
    Mono<Mono<T>> --> 이 구조 안에 있는 Mono는 flatMap, merge로 벗겨낼 수 있다.
                  --> flatMap, merge 순서를 보장하지 않으니 순서 보장이 필요하면 sequential을 사용하자
    Mono<Flux<T>> --> flatMapMany --> 에는 Flux<T> 순서가 보장된다.
    Flux<Flux<T>> ? collectList -> Flux<Mono<List<T>> --> Flux<List<T>>
     */


    public Mono<String> callWebClient(String request, long delay) {
        return Mono.defer(() -> {
            try {
                Thread.sleep(delay);
                return Mono.just(request + " -> 딜레이: " + delay);
            } catch (InterruptedException e) {
                return Mono.empty();
            }
        }).subscribeOn(Schedulers.boundedElastic());
    }
}
