package com.example.webfluxllm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
public class SubscriberPublisherAsyncTest {

    @Test
    void produceOneToNineFlux() {
        Flux<Integer> intFlux = Flux.create((sink -> {
            for (int i = 1; i <= 9; i++) {
                sink.next(i);
            }
            sink.complete();
        }));

        intFlux.subscribe(data -> System.out.println("webFlux가 구동 중!! : " + data));
        System.out.println("Netty 이벤트 루프로 스레드 복귀 !!");
    }
}
