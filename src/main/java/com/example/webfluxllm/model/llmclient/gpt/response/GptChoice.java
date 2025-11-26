package com.example.webfluxllm.model.llmclient.gpt.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GptChoice implements Serializable {

    @Serial
    private static final long serialVersionUID = -5305114566331006810L;

    private String finish_reason;
    private GptResponseMessageDto message;
    private GptResponseMessageDto delta;
}
