package com.example.webfluxllm.service.llmclient;

import com.example.webfluxllm.model.llmclient.LlmChatRequestDto;
import com.example.webfluxllm.model.llmclient.LlmChatResponseDto;
import com.example.webfluxllm.model.llmclient.LlmType;
import reactor.core.publisher.Mono;

/*
느슨한 결합

유연성 및 확장성
다양한LlmType을 계속해서 자유롭게 추가가능

다형성
원하는 webclient 구현체를 자유롭게 선택해서 사용할 수 있음
 */
public interface LlmWebClientService {
    Mono<LlmChatResponseDto> getChatCompletion(LlmChatRequestDto requestDto);

    LlmType getLlmType();
    //gptWebClientService, GeminiWebClientService
}
