package com.rhonn.board_back.dto.request.user;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchNicknameRequestDto {

    @NotBlank
    private String nickname;
}
