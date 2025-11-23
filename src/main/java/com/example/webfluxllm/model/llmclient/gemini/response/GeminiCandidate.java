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
public class GeminiCandidate implements Serializable {
    @Serial
    private static final long serialVersionUID = -4500665674249076207L;

    private GeminiContent content;
}
