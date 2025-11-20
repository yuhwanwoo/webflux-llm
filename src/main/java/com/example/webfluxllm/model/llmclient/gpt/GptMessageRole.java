package com.example.webfluxllm.model.llmclient.gpt;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum GptMessageRole {
    SYSTEM, // 시스템 프롬프트
    USER, // 유저 입력
    ASSISTANT, //ai 응답
    ;

    @JsonProperty
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
