package com.example.tobi.mypage.mapper;

import com.example.tobi.mypage.dto.UpdateNicknameDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageUserMapper {
    boolean existsByUserId(String userId);

    String findNicknameByUserId(String userId);

    boolean existsByNickname(String nickname);

    int updateNicknameByNickname(UpdateNicknameDTO updateNicknameDTO);
}