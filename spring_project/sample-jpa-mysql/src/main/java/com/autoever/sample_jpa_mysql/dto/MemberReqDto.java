package com.autoever.sample_jpa_mysql.dto;

import com.autoever.sample_jpa_mysql.constant.Authority;
import com.autoever.sample_jpa_mysql.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor  // 회원가입에 대한 요청
@AllArgsConstructor
@Builder
public class MemberReqDto {
    private String email;
    private String pwd;
    private String name;
    private String image;
    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .pwd(passwordEncoder.encode(pwd))
                .name(name)
                .image(image)
                .authority(Authority.ROLE_USER)
                .build();
    }
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, pwd);
    }
}
