package com.autoever.sample_jpa_mysql.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final String code;
    public CustomException(String code, String message) {
        super(message);
        this.code = code;
    }
}
