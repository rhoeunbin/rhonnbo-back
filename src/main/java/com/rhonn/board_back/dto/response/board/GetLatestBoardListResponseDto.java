package com.rhonn.board_back.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rhonn.board_back.common.ResponseCode;
import com.rhonn.board_back.common.ResponseMessage;
import com.rhonn.board_back.dto.object.BoardListItem;
import com.rhonn.board_back.dto.response.ResponseDto;
import com.rhonn.board_back.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetLatestBoardListResponseDto extends ResponseDto {

    private List<BoardListItem> latestList;

    private GetLatestBoardListResponseDto(List<BoardListViewEntity> entities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = BoardListItem.copyList(entities);
    }

    public static ResponseEntity<GetLatestBoardListResponseDto> success(List<BoardListViewEntity> entities) {
        GetLatestBoardListResponseDto result = new GetLatestBoardListResponseDto(entities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
