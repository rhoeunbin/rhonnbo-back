package com.rhonn.board_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rhonn.board_back.dto.response.ResponseDto;
import com.rhonn.board_back.dto.response.search.GetPopularListResponseDto;
import com.rhonn.board_back.repository.SearchLogRepository;
import com.rhonn.board_back.repository.resultSet.GetPopularListResultSet;
import com.rhonn.board_back.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {

        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try {
            resultSets = searchLogRepository.getPopularList();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetPopularListResponseDto.success(resultSets);
    }
}