package com.rhonn.board_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhonn.board_back.dto.request.board.PatchBoardRequestDto;
import com.rhonn.board_back.dto.request.board.PostBoardRequestDto;
import com.rhonn.board_back.dto.request.board.PostCommentRequestDto;
import com.rhonn.board_back.service.BoardService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rhonn.board_back.dto.response.board.PostBoardResponseDto;
import com.rhonn.board_back.dto.response.board.GetBoardResponseDto;
import com.rhonn.board_back.dto.response.board.PatchBoardResponseDto;
import com.rhonn.board_back.dto.response.board.DeleteBoardResponseDto;
import com.rhonn.board_back.dto.response.board.PostCommentResponseDto;
import com.rhonn.board_back.dto.response.board.GetCommentListResponseDto;
import com.rhonn.board_back.dto.response.board.PutFavoriteResponseDto;
import com.rhonn.board_back.dto.response.board.GetFavoriteListResponseDto;
import com.rhonn.board_back.dto.response.board.IncreaseViewCountResponseDto;
import com.rhonn.board_back.dto.response.board.GetLatestBoardListResponseDto;
import com.rhonn.board_back.dto.response.board.GetTop3BoardListResponseDto;
import com.rhonn.board_back.dto.response.board.GetSearchBoardListResponseDto;
import com.rhonn.board_back.dto.response.ResponseDto;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // POST : 게시물 생성
    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> createBoard(
            @RequestBody @Valid PostBoardRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.createBoard(requestBody, email);
        return response;
    }

    // GET : 최신 게시물 리스트 조회
    @GetMapping("/latest-list")
    public ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList() {
        ResponseEntity<? super GetLatestBoardListResponseDto> response = boardService.getLatestBoardList();
        return response;
    }

    // GET : 주간 top3 게시물 리스트 조회
    @GetMapping("/top3-list")
    public ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList() {
        ResponseEntity<? super GetTop3BoardListResponseDto> response = boardService.getTop3BoardList();
        return response;
    }

    @GetMapping(value = { "/search-list/{searchWord}", "/search-list/{searchWord}/{preSearchWord}" })
    public ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(
            @PathVariable("searchWord") String searchWord,
            @PathVariable(value = "preSearchWord", required = false) String preSearchWord) {

        // 한글 디코딩 처리
        try {
            String decodedSearchWord = java.net.URLDecoder.decode(searchWord, "UTF-8");

            ResponseEntity<? super GetSearchBoardListResponseDto> response = boardService.getSearchBoardList(
                    decodedSearchWord,
                    preSearchWord);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    // GET : 게시물 조회
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    // PATCH : 게시물 수정
    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> deleteBoard(
            @RequestBody @Valid PatchBoardRequestDto requestBody,
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBody, boardNumber,
                email);
        return response;
    }

    // DELETE : 게시물 삭제
    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber, email);
        return response;
    }

    // POST : 댓글 생성
    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> createComment(
            @RequestBody @Valid PostCommentRequestDto requestBody,
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PostCommentResponseDto> response = boardService.createComment(requestBody, boardNumber,
                email);
        return response;
    }

    // GET : 댓글 리스트 조회
    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }

    // PUT : 좋아요 수 입력
    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PutFavoriteResponseDto> response = boardService.putFavorite(boardNumber, email);
        return response;
    }

    // GET : 좋아요 수 조회
    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetFavoriteListResponseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }

    // GET : 게시물 조회수
    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super IncreaseViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }

}
