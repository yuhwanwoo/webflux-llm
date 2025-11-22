package com.example.webfluxllm.service.user.chat;

import com.example.webfluxllm.model.llmclient.LlmChatRequestDto;
import com.example.webfluxllm.model.llmclient.LlmChatResponseDto;
import com.example.webfluxllm.model.user.chat.UserChatRequestDto;
import com.example.webfluxllm.model.user.chat.UserChatResponseDto;
import com.example.webfluxllm.service.llmclient.LlmWebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserChatServiceImpl implements UserChatService {
    private final LlmWebClientService llmWebClientService;

    @Override
    public Mono<UserChatResponseDto> getOneShotChat(UserChatRequestDto userChatRequestDto) {
        LlmChatRequestDto llmChatRequestDto = new LlmChatRequestDto((userChatRequestDto), "요청에 적절히 응답해주세요.");
        Mono<LlmChatResponseDto> chatCompletionMono = llmWebClientService.getChatCompletion(llmChatRequestDto);
        return chatCompletionMono.map(UserChatResponseDto::new);
    }
}
