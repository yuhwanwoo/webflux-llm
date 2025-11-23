package com.example.webfluxllm.model.llmclient.gemini.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class GeminiGenerationConfigDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3667739832656946892L;

    private String responseMimeType;

    public GeminiGenerationConfigDto() {
        this.responseMimeType = "application/json";
    }
}
