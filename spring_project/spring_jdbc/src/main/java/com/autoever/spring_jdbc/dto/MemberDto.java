package com.autoever.spring_jdbc.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {
    private String email;
    private String password;
    private String name;
    private LocalDateTime date;
}