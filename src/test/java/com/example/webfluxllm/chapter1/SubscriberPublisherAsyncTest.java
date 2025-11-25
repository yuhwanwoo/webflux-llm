package com.example.webfluxllm.chapter1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@SpringBootTest
public class SubscriberPublisherAsyncTest {

    @Test
    void produceOneToNineFlux() {
        Flux<Integer> intFlux = Flux.<Integer>create(sink -> {
            for (int i = 1; i <= 9; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribeOn(Schedulers.boundedElastic());

        intFlux.subscribe(data -> {
                    System.out.println("처리되고 있는 스레이 이름: " + Thread.currentThread().getName());
                    System.out.println("webFlux가 구동 중!! : " + data);
                }
        );
        System.out.println("Netty 이벤트 루프로 스레드 복귀 !!");
        try {
            Thread.sleep(5000); // 바로 죽어버림
        } catch (InterruptedException e) {

        }
    }
}
