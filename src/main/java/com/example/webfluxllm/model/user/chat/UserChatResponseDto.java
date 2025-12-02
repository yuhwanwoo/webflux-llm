package com.example.webfluxllm.model.user.chat;

import com.example.webfluxllm.exception.CommonError;
import com.example.webfluxllm.model.llmclient.LlmChatResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserChatResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -1958795989277987236L;

    private String response;
    private String title;
    private CommonError error;

    public UserChatResponseDto(String title, String response) {
        this.title = title;
        this.response = response;
    }
    public UserChatResponseDto(LlmChatResponseDto llmChatResponseDto) {
        this.title = llmChatResponseDto.getTitle();
        this.response = llmChatResponseDto.getLlmResponse();
        this.error = llmChatResponseDto.getError();
    }

}
