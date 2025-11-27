package com.example.webfluxllm.model.llmclient.gemini.response;

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
@Getter
@Setter
public class GeminiChatResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 3663093236837379050L;

    private List<GeminiCandidate> candidates;

    public String getSingleText() {
        return candidates.stream().findFirst()
                .flatMap(candidate ->
                        candidate.getContent().getParts().stream().findFirst()
                                .map(part -> part.getText()))
                .orElseThrow(() -> new ErrorTypeException("[GptResponse] There is no choices.", CustomErrorType.GPT_RESPONSE_ERROR));
    }
}
