package com.autoever.sample_jpa_mysql.controller;

import com.autoever.sample_jpa_mysql.dto.ChatRoomReqDto;
import com.autoever.sample_jpa_mysql.dto.ChatRoomResDto;
import com.autoever.sample_jpa_mysql.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/new")
    public ResponseEntity<String> createRoom(@RequestBody ChatRoomReqDto chatRoomDto) {
        log.warn("chatRoomDto : {}", chatRoomDto);
        ChatRoomResDto room = chatService.createRoom(chatRoomDto.getName());
        System.out.println(room.getRoomId());
        return ResponseEntity.ok(room.getRoomId());
    }
    @GetMapping("/list")
    public ResponseEntity<List<ChatRoomResDto>> findAllRoom() {
        return ResponseEntity.ok(chatService.findAllRoom());
    }

    // 방 정보 가져오기
    @GetMapping("/room/{roomId}")
    public ResponseEntity<ChatRoomResDto> findRoomById(@PathVariable String roomId) {
        return ResponseEntity.ok(chatService.findRoomById(roomId));
    }
}