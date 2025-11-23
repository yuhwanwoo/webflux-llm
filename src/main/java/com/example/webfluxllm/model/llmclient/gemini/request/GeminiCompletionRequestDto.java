package com.example.webfluxllm.model.llmclient.gemini.request;

import com.example.webfluxllm.model.llmclient.gemini.GeminiMessageRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeminiCompletionRequestDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -1019581971273907187L;

    private GeminiMessageRole role;
    private String content;

    public GeminiCompletionRequestDto(String content) {
        this.content = content;
    }
}
