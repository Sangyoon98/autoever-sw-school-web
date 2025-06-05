package com.autoever.sample_jpa_mysql.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 매개변수가 전부 있는 생성자
// @Data   // 모든 Annotation을 한번에 적용
public class MemberLoginReqDto {
    private String email;
    private String pwd;
}
