package com.example.tobi.mypage.service;

import com.example.tobi.mypage.dto.UpdateNicknameDTO;
import com.example.tobi.mypage.mapper.MyPageUserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageUserService {

    private final MyPageUserMapper myPageUserMapper;

    // 아이디 유효성 검사
    public boolean isValidUserId(String userId) {
        return myPageUserMapper.existsByUserId(userId);
    }

    // 아이디로 닉네임 가져오기
    public String fetchNicknameByUserId(String userId) {
        return myPageUserMapper.findNicknameByUserId(userId);
    }

    public boolean checkNicknameExists(String nickname) {

        return myPageUserMapper.existsByNickname(nickname);
    }

    // 닉네임을 통해 사용자 정보 수정
    public boolean updateNicknameByNickname(UpdateNicknameDTO updateNicknameDTO) {
        System.out.println("Service 전달 닉네임: " + updateNicknameDTO.getNickname());
        System.out.println("USERiD : "+updateNicknameDTO.getUserId());
        int rowsAffected = myPageUserMapper.updateNicknameByNickname(updateNicknameDTO);
        System.out.println("수정된 행 수: " + rowsAffected);
        return rowsAffected > 0;
    }

}