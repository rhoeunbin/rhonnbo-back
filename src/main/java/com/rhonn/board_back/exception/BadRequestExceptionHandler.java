package com.rhonn.board_back.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rhonn.board_back.dto.response.ResponseDto;

@RestControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
    public ResponseEntity<ResponseDto> validationExceptionHandler(Exception e) {
        return ResponseDto.validationFailed();
    }

}
