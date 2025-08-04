package com.rhonn.board_back.service;

import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.dto.request.board.CreateBoardRequestDto;
import com.rhonn.board_back.dto.response.board.CreateBoardResponseDto;
import com.rhonn.board_back.dto.response.board.GetBoardResponseDto;
import com.rhonn.board_back.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {

    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);

    ResponseEntity<? super CreateBoardResponseDto> createBoard(CreateBoardRequestDto dto, String email);

    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
}
