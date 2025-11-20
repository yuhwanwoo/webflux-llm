package com.example.webfluxllm.service.user.chat;

import com.example.webfluxllm.model.llmclient.LlmChatRequestDto;
import com.example.webfluxllm.model.user.chat.UserChatRequestDto;
import com.example.webfluxllm.model.user.chat.UserChatResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserChatServiceImpl implements UserChatService {
    @Override
    public Mono<UserChatResponseDto> getOneShotChat(UserChatRequestDto userChatRequestDto) {
        LlmChatRequestDto llmChatRequestDto = new LlmChatRequestDto((userChatRequestDto), "요청에 적절히 응답해주세요.");
        return null;
    }
}
