package com.example.tobi.mypage.service;


import com.example.tobi.mypage.dto.CheckUserIdDTO;
import com.example.tobi.mypage.dto.UpdateNicknameDTO;
import com.example.tobi.mypage.mapper.MyPageUserMapper;
import com.example.tobi.mypage.model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageUserService {

    private final MyPageUserMapper myPageUserMapper;

    public boolean checkId(String userId) {


        return myPageUserMapper.findById(userId) != null; // id  확인
    }

    public String getNicknameByUserId(String userId) {
        User user = myPageUserMapper.findById(userId);
        if (user != null) {
            return user.getNickname();
        }
        return null;
    }


    public void updateNickname(String userId, String newNickname) {
        User user = myPageUserMapper.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        myPageUserMapper.updateNicknameById(user.getId(), newNickname); // 닉네임 업데이트
    }


}
