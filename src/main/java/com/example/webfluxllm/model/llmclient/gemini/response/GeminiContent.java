package com.example.webfluxllm.model.llmclient.gemini.response;

import com.example.webfluxllm.model.llmclient.gemini.GeminiMessageRole;
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
public class GeminiContent implements Serializable {
    @Serial
    private static final long serialVersionUID = 7204352625995511682L;

    private List<GeminiPart> parts;
    private GeminiMessageRole role;

    public GeminiContent(List<GeminiPart> parts) {
        this.parts = parts;
    }
}
