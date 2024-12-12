package com.example.tobi.mypage.service;

import com.example.tobi.mypage.mapper.MyPageUserMapper;
import com.example.tobi.mypage.model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageUserService {

    private final MyPageUserMapper myPageUserMapper;

    public boolean checkId(int id,String userId) {
        User user = myPageUserMapper.findById(id);

        if (user == null) {
            return false;
        }

        return user.getUser_id().equals(userId);
    }


    public void newUpdateNickname(int id, String newNickname) {
        User user = myPageUserMapper.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        myPageUserMapper.updateNicknameById(id, newNickname);
    }
}
