package com.rhonn.board_back.service;

import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.dto.request.user.PatchNicknameRequestDto;
import com.rhonn.board_back.dto.request.user.PatchProfileImgRequestDto;
import com.rhonn.board_back.dto.response.user.GetUserResponseDto;
import com.rhonn.board_back.dto.response.user.GetSignInUserResponseDto;
import com.rhonn.board_back.dto.response.user.PatchNicknameResponseDto;
import com.rhonn.board_back.dto.response.user.PatchProfileImgResponseDto;

public interface UserService {

    ResponseEntity<? super GetUserResponseDto> getUser(String email);

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);

    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);

    ResponseEntity<? super PatchProfileImgResponseDto> patchProfileImg(PatchProfileImgRequestDto dto, String email);
}
