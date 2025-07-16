package com.rhonn.board_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhonn.board_back.entity.UserEntity;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, String> {

}
