package com.rhonn.board_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhonn.board_back.dto.response.board.CreateBoardResponseDto;
import com.rhonn.board_back.dto.request.board.CreateBoardRequestDto;
import com.rhonn.board_back.service.BoardService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<? super CreateBoardResponseDto> createBoard(
            @RequestBody @Valid CreateBoardRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super CreateBoardResponseDto> response = boardService.createBoard(requestBody, email);
        return response;
    }

}
