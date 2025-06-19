package com.autoever.sample_jpa_mysql.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@Builder(toBuilder = true) // 빌더 기반 객체 복사 허용
public class ChatRoomResDto {

    private String roomId;
    private String name;
    private LocalDateTime regDate;

    @JsonIgnore
    @Builder.Default // 필드에 기본값 설정!
    private Set<WebSocketSession> sessions = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public boolean isSessionEmpty() {
        return this.sessions.isEmpty();
    }
}