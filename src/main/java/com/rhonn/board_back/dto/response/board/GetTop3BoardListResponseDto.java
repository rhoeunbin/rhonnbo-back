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
public class GetTop3BoardListResponseDto extends ResponseDto {

    private List<BoardListItem> top3List;

    private GetTop3BoardListResponseDto(List<BoardListViewEntity> entities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.top3List = BoardListItem.getList(entities);
    }

    public static ResponseEntity<GetTop3BoardListResponseDto> success(List<BoardListViewEntity> entities) {
        GetTop3BoardListResponseDto result = new GetTop3BoardListResponseDto(entities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
