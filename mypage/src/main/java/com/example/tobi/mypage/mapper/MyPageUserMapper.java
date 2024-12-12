package com.example.tobi.mypage.mapper;

import com.example.tobi.mypage.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyPageUserMapper {
    User findById(@Param("id") int id);
    void updateNicknameById(
            @Param("id") int id, @Param("newNickname") String newNickname);
}
