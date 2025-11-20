package com.example.webfluxllm.model.llmclient.gpt.request;

import com.example.webfluxllm.model.llmclient.gpt.GptMessageRole;
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
public class GptCompletionRequestDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -7019581971273907187L;

    private GptMessageRole role;
    private String content;
}
