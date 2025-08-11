package com.rhonn.board_back.service;

import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.dto.response.search.GetPopularListResponseDto;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();

}
