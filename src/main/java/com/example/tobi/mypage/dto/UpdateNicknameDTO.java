package com.example.tobi.mypage.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateNicknameDTO {
    private String userId;
    private String nickname;


}
