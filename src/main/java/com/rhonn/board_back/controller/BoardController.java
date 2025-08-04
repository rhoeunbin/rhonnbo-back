package com.rhonn.board_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhonn.board_back.dto.response.board.CreateBoardResponseDto;
import com.rhonn.board_back.dto.request.board.CreateBoardRequestDto;
import com.rhonn.board_back.service.BoardService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.rhonn.board_back.dto.response.board.GetBoardResponseDto;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super CreateBoardResponseDto> createBoard(
            @RequestBody @Valid CreateBoardRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super CreateBoardResponseDto> response = boardService.createBoard(requestBody, email);
        return response;
    }

}
