package com.rhonn.board_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rhonn.board_back.dto.request.board.CreateBoardRequestDto;
import com.rhonn.board_back.dto.response.ResponseDto;
import com.rhonn.board_back.dto.response.board.CreateBoardResponseDto;
import com.rhonn.board_back.dto.response.board.GetBoardResponseDto;
import com.rhonn.board_back.entity.BoardEntity;
import com.rhonn.board_back.entity.ImageEntity;
import com.rhonn.board_back.repository.BoardRepository;
import com.rhonn.board_back.repository.ImageRepository;
import com.rhonn.board_back.repository.UserRepository;
import com.rhonn.board_back.repository.resultSet.GetBoardResultSet;
import com.rhonn.board_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {

        GetBoardResultSet resultSet = null;
        List<ImageEntity> imageEntities = new ArrayList<>();

        try {
            resultSet = boardRepository.getBoard(boardNumber);
            if (resultSet == null)
                return GetBoardResponseDto.notExistBoard();

            imageEntities = imageRepository.findByBoardNumber(boardNumber);

            // 조회수 올리기
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            boardEntity.increaseViewCount();
            boardRepository.save(boardEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetBoardResponseDto.success(resultSet, imageEntities);
    }

    @Override
    public ResponseEntity<? super CreateBoardResponseDto> createBoard(CreateBoardRequestDto dto, String email) {

        try {
            boolean existedEmail = userRepository.existsByEmail(email);
            if (!existedEmail)
                return CreateBoardResponseDto.notExistUser();

            BoardEntity boardEntity = new BoardEntity(dto, email);
            boardRepository.save(boardEntity);

            int boardNumber = boardEntity.getBoardNumber();
            List<String> boardImageList = dto.getBoardImageList();
            List<ImageEntity> imageEntities = new ArrayList<>();

            for (String image : boardImageList) {
                ImageEntity imageEntity = new ImageEntity(boardNumber, image);
                imageEntities.add(imageEntity);
            }

            imageRepository.saveAll(imageEntities);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return CreateBoardResponseDto.success();
    }
}
