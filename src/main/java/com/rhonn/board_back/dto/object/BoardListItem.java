package com.rhonn.board_back.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.rhonn.board_back.entity.BoardListViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardListItem {

    private int boardNumber;
    private String title;
    private String content;
    private String boardTitleImage;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private String writeDatetime;
    private String writerNickname;
    private String writerProfileImage;

    public BoardListItem(BoardListViewEntity entity) {
        this.boardNumber = entity.getBoardNumber();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.boardTitleImage = entity.getTitleImage();
        this.favoriteCount = entity.getFavoriteCount();
        this.commentCount = entity.getCommentCount();
        this.viewCount = entity.getViewCount();
        this.writeDatetime = entity.getWriteDatetime();
        this.writerNickname = entity.getWriterNickname();
        this.writerProfileImage = entity.getWriterProfileImage();
    }

    public static List<BoardListItem> getList(List<BoardListViewEntity> entities) {
        List<BoardListItem> list = new ArrayList<>();
        for (BoardListViewEntity entity : entities) {
            list.add(new BoardListItem(entity));
        }
        return list;
    }
}
