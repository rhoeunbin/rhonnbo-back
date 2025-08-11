package com.rhonn.board_back.service;

import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.dto.request.board.PostBoardRequestDto;
import com.rhonn.board_back.dto.request.board.PostCommentRequestDto;
import com.rhonn.board_back.dto.request.board.PatchBoardRequestDto;

import com.rhonn.board_back.dto.response.board.PostBoardResponseDto;
import com.rhonn.board_back.dto.response.board.GetBoardResponseDto;
import com.rhonn.board_back.dto.response.board.PatchBoardResponseDto;
import com.rhonn.board_back.dto.response.board.DeleteBoardResponseDto;
import com.rhonn.board_back.dto.response.board.GetCommentListResponseDto;
import com.rhonn.board_back.dto.response.board.PostCommentResponseDto;
import com.rhonn.board_back.dto.response.board.GetFavoriteListResponseDto;
import com.rhonn.board_back.dto.response.board.PutFavoriteResponseDto;
import com.rhonn.board_back.dto.response.board.IncreaseViewCountResponseDto;
import com.rhonn.board_back.dto.response.board.GetLatestBoardListResponseDto;

public interface BoardService {
        ResponseEntity<? super PostBoardResponseDto> createBoard(PostBoardRequestDto dto, String email);

        ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);

        ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber,
                        String email);

        ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);

        ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();

        ResponseEntity<? super PostCommentResponseDto> createComment(PostCommentRequestDto dto, Integer boardNumber,
                        String email);

        ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);

        ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);

        ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

        ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);
}
