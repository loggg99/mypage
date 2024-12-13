package com.example.tobi.mypage.dto;

import com.example.tobi.mypage.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNicknameDTO {
    private String userId;
    private String nickname;


}
