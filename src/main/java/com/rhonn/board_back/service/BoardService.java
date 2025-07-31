package com.rhonn.board_back.service;

import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.dto.request.board.CreateBoardRequestDto;
import com.rhonn.board_back.dto.response.board.CreateBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super CreateBoardResponseDto> createBoard(CreateBoardRequestDto dto, String email);

}
