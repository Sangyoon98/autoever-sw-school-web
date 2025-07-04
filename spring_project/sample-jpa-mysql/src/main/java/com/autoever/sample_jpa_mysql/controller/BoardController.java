package com.autoever.sample_jpa_mysql.controller;

import com.autoever.sample_jpa_mysql.dto.BoardResDto;
import com.autoever.sample_jpa_mysql.dto.BoardWriteDto;
import com.autoever.sample_jpa_mysql.dto.PageResDto;
import com.autoever.sample_jpa_mysql.entity.Board;
import com.autoever.sample_jpa_mysql.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;    // 의존성 주입

    @PostMapping("/new")
    public ResponseEntity<Boolean> newBoard(@RequestBody BoardWriteDto boardWriteDto) {
        Board board = boardService.saveAndReturn(boardWriteDto);
        // Flask 분석 요청 보내기
        try {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> request = new HashMap<>();
            request.put("postId",  board.getId());
            request.put("title", board.getTitle());
            request.put("content", board.getContent());
            restTemplate.postForEntity("http://127.0.0.1:5000/predict", request, Boolean.class);
        } catch (Exception e) {
            log.error("Flask 분석 요청 실패: {}", e.getMessage());
        }
        return ResponseEntity.ok(true);
    }

    // 게시글 등록 : 입력(BoardWriteDto), 반환(boolean)
    @PostMapping("/write")
    public ResponseEntity<Boolean> boardWrite(@RequestBody BoardWriteDto boardWriteDto) {
        boolean isSuccess = boardService.addBoard(boardWriteDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 게시글 수정 ; 입력(id, BoardWriteDto), 반환(boolean)
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> modifyBoard(@PathVariable Long id, @RequestBody BoardWriteDto boardWriteDto) {
        boolean isSuccess = boardService.modifyBoard(id, boardWriteDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 게시글 삭제 : 입력(id), 반환(boolean)
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBoard(@PathVariable Long id) {
        boolean isSuccess = boardService.deleteBoard(id);
        return ResponseEntity.ok(isSuccess);
    }

    // 게시글 검색 : 입력(제목에 포함된 문자열), 반환(List<BoardResDto>)
    @GetMapping("/list/search")
    public ResponseEntity<List<BoardResDto>> searchBoardByTitle(@RequestParam String keyword) {
        List<BoardResDto> boardResDtoList = boardService.searchBoardByTitle(keyword);
        return ResponseEntity.ok(boardResDtoList);
    }

    // 게시글 전체 조회 : 입력(), 반환(List<BoardResDto)
    @GetMapping("/list")
    public ResponseEntity<List<BoardResDto>> getBoardList() {
        List<BoardResDto> boardResDtoList = boardService.getBoardList();
        return ResponseEntity.ok(boardResDtoList);
    }

    // 게시글 단건 조회 : 입력(id), 반환(BoardResDto)
    @GetMapping("/list/{id}")
    public ResponseEntity<BoardResDto> getBoardById(@PathVariable Long id) {
        BoardResDto boardResDto = boardService.getBoardById(id);
        return ResponseEntity.ok(boardResDto);
    }

    // 게시글 페이징 : 입력(페이지 번호, 페이지 사이즈), 반환(PageResDto)
    @GetMapping("/pagelist")
    public ResponseEntity<PageResDto<BoardResDto>> getBoardPageList(@RequestParam int page, @RequestParam int size) {
        PageResDto<BoardResDto> pageResDto = boardService.getBoardPageList(page, size);
        return ResponseEntity.ok(pageResDto);
    }
}
