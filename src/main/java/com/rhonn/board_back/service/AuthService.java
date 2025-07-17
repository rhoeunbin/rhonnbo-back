package com.rhonn.board_back.service;

import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.dto.request.auth.SignInRequestDto;
import com.rhonn.board_back.dto.request.auth.SignUpRequestDto;
import com.rhonn.board_back.dto.response.auth.SignUpResponseDto;
import com.rhonn.board_back.dto.response.auth.SignInResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
