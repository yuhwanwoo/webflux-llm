package com.example.webfluxllm.model.llmclient.gemini.response;

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
public class GeminiPart implements Serializable {
    @Serial
    private static final long serialVersionUID = -7993395210692044482L;

    private String text;
}
