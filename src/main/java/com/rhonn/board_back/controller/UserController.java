package com.rhonn.board_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhonn.board_back.dto.request.user.PatchProfileImgRequestDto;
import com.rhonn.board_back.dto.request.user.PatchNicknameRequestDto;

import com.rhonn.board_back.dto.response.user.GetUserResponseDto;
import com.rhonn.board_back.dto.response.user.GetSignInUserResponseDto;
import com.rhonn.board_back.dto.response.user.PatchNicknameResponseDto;
import com.rhonn.board_back.dto.response.user.PatchProfileImgResponseDto;
import com.rhonn.board_back.service.UserService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<? super GetUserResponseDto> getUser(
            @PathVariable("email") String email) {
        ResponseEntity<? super GetUserResponseDto> response = userService.getUser(email);
        return response;
    }

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }

    @PatchMapping("/nickname")
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(
            @RequestBody @Valid PatchNicknameRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchNicknameResponseDto> response = userService.patchNickname(requestBody, email);
        return response;
    }

    @PatchMapping("/profile-image")
    public ResponseEntity<? super PatchProfileImgResponseDto> patchProfileImg(
            @RequestBody @Valid PatchProfileImgRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchProfileImgResponseDto> response = userService.patchProfileImg(requestBody, email);
        return response;
    }
}
