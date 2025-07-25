package com.autoever.sample_jpa_mysql.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;
}