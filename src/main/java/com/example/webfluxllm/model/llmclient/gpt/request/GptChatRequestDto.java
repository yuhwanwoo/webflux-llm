package com.example.webfluxllm.model.llmclient.gpt.request;

import com.example.webfluxllm.model.llmclient.LlmModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GptChatRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -2487170261216548896L;

    private List<GptCompletionRequestDto> messages;
    private LlmModel model;
    private Boolean stream;


}
