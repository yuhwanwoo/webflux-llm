package com.example.webfluxllm.exception;

import java.io.Serial;

public class ErrorTypeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -4312727055666426753L;

    private CustomErrorType errorType;

    public ErrorTypeException(String message, CustomErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public CustomErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return "Code: " + errorType.getCode() + ", Message : " + super.getMessage();
    }
}
