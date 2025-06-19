package com.autoever.sample_jpa_mysql.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class ChatMessageDto {
    public enum MessageType { ENTER, TALK, CLOSE }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
