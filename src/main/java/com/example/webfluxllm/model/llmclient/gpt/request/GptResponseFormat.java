package com.example.webfluxllm.model.llmclient.gpt.request;

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
public class GptResponseFormat implements Serializable {
    @Serial
    private static final long serialVersionUID = 2474148460504479048L;

    private String type;
}
