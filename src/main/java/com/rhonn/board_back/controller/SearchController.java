package com.rhonn.board_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhonn.board_back.service.SearchService;
import com.rhonn.board_back.dto.response.ResponseDto;
import com.rhonn.board_back.dto.response.search.GetPopularListResponseDto;
import com.rhonn.board_back.dto.response.search.GetRelationListResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    // GET : 인기 검색어 리스트 조회
    @GetMapping("/popular-list")
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {
        ResponseEntity<? super GetPopularListResponseDto> response = searchService.getPopularList();
        return response;
    }

    // GET : 연관 검색어 리스트 조회
    @GetMapping("/{searchWord}/relation-list")
    public ResponseEntity<? super GetRelationListResponseDto> getRelationList(
            @PathVariable("searchWord") String searchWord) {

        try {
            String decodedSearchWord = java.net.URLDecoder.decode(searchWord, "UTF-8");

            // 검색어 유효성 검사
            if (decodedSearchWord == null || decodedSearchWord.trim().isEmpty()) {
                return ResponseDto.validationFailed();
            }

            ResponseEntity<? super GetRelationListResponseDto> response = searchService
                    .getRelationList(decodedSearchWord);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
}
