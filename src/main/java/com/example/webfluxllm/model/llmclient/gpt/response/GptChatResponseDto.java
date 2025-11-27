package com.example.webfluxllm.model.llmclient.gpt.response;

import com.example.webfluxllm.exception.CustomErrorType;
import com.example.webfluxllm.exception.ErrorTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GptChatResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8873793756511721146L;

    private List<GptChoice> choices;

    public GptChoice getSingleChoice() {
        return choices.stream().findFirst().orElseThrow(() ->
                new ErrorTypeException("[GptResponse] There is no choices.", CustomErrorType.GPT_RESPONSE_ERROR));

    }
}
