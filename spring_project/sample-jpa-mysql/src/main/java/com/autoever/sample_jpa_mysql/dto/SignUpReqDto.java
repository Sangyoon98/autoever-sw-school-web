package com.autoever.sample_jpa_mysql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpReqDto {
    private String email;
    private String pwd;
    private String name;
}
