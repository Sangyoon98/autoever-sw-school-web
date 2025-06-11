package com.autoever.sample_jpa_mysql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  // 회원가입에 대한 요청
public class MemberReqDto {
    private String email;
    private String pwd;
    private String name;
    private String image;
}
