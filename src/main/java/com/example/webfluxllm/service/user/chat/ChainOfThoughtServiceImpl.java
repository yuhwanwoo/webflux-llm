package com.example.webfluxllm.service.user.chat;

import com.example.webfluxllm.model.llmclient.LlmChatRequestDto;
import com.example.webfluxllm.model.llmclient.LlmModel;
import com.example.webfluxllm.model.llmclient.LlmType;
import com.example.webfluxllm.model.user.chat.UserChatRequestDto;
import com.example.webfluxllm.model.user.chat.UserChatResponseDto;
import com.example.webfluxllm.service.llmclient.LlmWebClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChainOfThoughtServiceImpl implements ChainOfThoughtService {
    /*
    1단계 : 문제를 이해햐기
    2단계 : 문제를 단계별로 풀어가기
    3단계 : 최종 응답
    범용성 부족!

    1. 사용자의 요청을 효율적으로 분석하기 위한 단계를 LLM에게 물어봄
        -> anwserList: 분석 단계를 LLM이 응답

    2. 분석 단계 별로 LLM에게 요청을 보내어 상세하게 분석

    3. 단계별로 분석된 결과를 종합하여 최종 응답
     */
    private final Map<LlmType, LlmWebClientService> llmWebClientServiceMap;
    private final ObjectMapper objectMapper;

    @Override
    public Flux<UserChatResponseDto> getChainOfThoughtResponse(UserChatRequestDto userChatRequestDto) {
        return Flux.<UserChatResponseDto>create(sink -> {
            String userRequest = userChatRequestDto.getRequest();
            LlmModel requestModel = userChatRequestDto.getLlmModel();

            String establishingThoughtChainPrompt = String.format("""
                    다음은 사용자의 입력입니다: "%s"
                    사용자에게 체계적으로 답변하기 위해 어떤 단계들이 필요할지 정리해주세요.
                    """, userRequest);

            String establishingThoughtChainSystemPrompt = """
                    아래처럼 List<String> answerList의 형태를 가지는 JSON FORMAT으로 응답해주세요.
                    <JSONSCHEMA>
                    {
                        "answerList": ["", ...]
                    }
                    </JSONSCHEMA>
                    """;

            LlmChatRequestDto llmChatRequestDto = new LlmChatRequestDto(establishingThoughtChainPrompt, establishingThoughtChainSystemPrompt, true, requestModel);

            LlmWebClientService llmWebClientService = llmWebClientServiceMap.get(requestModel.getLlmType());

        });
    }
}
