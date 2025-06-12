package com.autoever.sample_jpa_mysql.service;

import com.autoever.sample_jpa_mysql.dto.BoardResDto;
import com.autoever.sample_jpa_mysql.dto.BoardWriteDto;
import com.autoever.sample_jpa_mysql.dto.PageResDto;
import com.autoever.sample_jpa_mysql.entity.Board;
import com.autoever.sample_jpa_mysql.entity.Member;
import com.autoever.sample_jpa_mysql.repository.BoardRepository;
import com.autoever.sample_jpa_mysql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // 게시글 등록 : 반환값 Boolean
    public boolean addBoard(BoardWriteDto boardWriteDto) {
        try {
            Board board = convertDtoToEntity(boardWriteDto);
            boardRepository.save(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 등록 실패 : {}", e.getMessage());
            return false;
        }
    }

    // 게시글 전체 조회 : 반환값 List<Board>
    public List<BoardResDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResDto> boardResDtoList = new ArrayList<>();

        for (Board board : boardList) {
            BoardResDto boardResDto = convertEntityToDto(board);
            boardResDtoList.add(boardResDto);
        }
        return boardResDtoList;
    }

    // 게시글 단건 조회 : 반환값 Board
    public BoardResDto getBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("해당 ID의 게시글이 존재하지 않습니다."));
        return convertEntityToDto(board);
    }

    // 게시글 수정 : 반환값 Boolean
    public boolean modifyBoard(Long boardId, BoardWriteDto boardWriteDto) {
        try {
            Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("해당 ID의 게시글이 존재하지 않습니다."));
            Member member = memberRepository.findByEmail(boardWriteDto.getEmail()).orElseThrow(() -> new RuntimeException("해당 이메일의 회원이 존재하지 않습니다."));
            board.setTitle(boardWriteDto.getTitle());
            board.setContent(boardWriteDto.getContent());
            board.setImage(boardWriteDto.getImage());
            board.setMember(member);
            boardRepository.save(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 수정 실패 : {}", e.getMessage());
            return false;
        }
    }

    // 게시글 삭제 : 반환값 Boolean
    public boolean deleteBoard(Long boardId) {
        try {
            Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("해당 ID의 게시글이 존재하지 않습니다."));
            //if (!board.getMember().getEmail().equals(email)) throw new RuntimeException("작성자만 삭제할 수 있습니다.");
            boardRepository.delete(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 삭제 실패 : {}", e.getMessage());
            return false;
        }
    }

    // 게시글 검색 : 반환값 List<Board>
    public List<BoardResDto> searchBoardByTitle(String keyword) {
        List<Board> boardList = boardRepository.findByTitleContainingIgnoreCase(keyword);
        List<BoardResDto> boardResDtoList = new ArrayList<>();

        for (Board board : boardList) {
            BoardResDto boardResDto = convertEntityToDto(board);
            boardResDtoList.add(boardResDto);
        }
        return boardResDtoList;
    }

    // 게시글 페이징 처리
    public PageResDto<BoardResDto> getBoardPageList(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Board> boardPage = boardRepository.findAll(pageRequest);
        Page<BoardResDto>  boardResDtoPage = boardPage.map(this::convertEntityToDto);
        return new PageResDto<>(boardResDtoPage);
    }

    // Entity -> DTO
    private BoardResDto convertEntityToDto(Board board) {
        BoardResDto boardResDto = new BoardResDto();
        boardResDto.setBoardId(board.getId());
        boardResDto.setTitle(board.getTitle());
        boardResDto.setContent(board.getContent());
        boardResDto.setImage(board.getImage());
        boardResDto.setCreateTime(board.getCreateTime());
        boardResDto.setEmail(board.getMember().getEmail());
        return boardResDto;
    }

    // DTO -> Entity
    private Board convertDtoToEntity(BoardWriteDto boardWriteDto) {
        Board board = new Board();
        Member member = memberRepository.findByEmail(boardWriteDto.getEmail()).orElseThrow(() -> new RuntimeException("해당 이메일의 회원이 존재하지 않습니다."));
        board.setTitle(boardWriteDto.getTitle());
        board.setContent(boardWriteDto.getContent());
        board.setImage(boardWriteDto.getImage());
        board.setMember(member);
        return board;
    }
}
