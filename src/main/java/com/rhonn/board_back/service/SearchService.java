package com.rhonn.board_back.service;

import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.dto.response.search.GetPopularListResponseDto;
import com.rhonn.board_back.dto.response.board.GetLatestBoardListResponseDto;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();

}
