package com.example.webfluxllm.service.user.chat;

import com.example.webfluxllm.model.user.chat.UserChatRequestDto;
import com.example.webfluxllm.model.user.chat.UserChatResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserChatService {
    Mono<UserChatResponseDto> getOneShotChat(UserChatRequestDto userChatRequestDto);

    Flux<UserChatResponseDto> getOneShotChatStream(UserChatRequestDto userChatRequestDto);
}
