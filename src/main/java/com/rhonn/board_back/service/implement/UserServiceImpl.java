package com.rhonn.board_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rhonn.board_back.dto.response.ResponseDto;
import com.rhonn.board_back.dto.response.user.GetSignInUserResponseDto;
import com.rhonn.board_back.dto.response.user.GetUserResponseDto;
import com.rhonn.board_back.entity.UserEntity;
import com.rhonn.board_back.repository.UserRepository;
import com.rhonn.board_back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {

        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null)
                return GetUserResponseDto.notExistUser();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {
        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null)
                return GetSignInUserResponseDto.notExistUser();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);
    }
}
