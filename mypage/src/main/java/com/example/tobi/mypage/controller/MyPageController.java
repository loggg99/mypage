package com.example.tobi.mypage.controller;

import com.example.tobi.mypage.dto.CheckUserIdDTO;
import com.example.tobi.mypage.dto.UpdateNicknameDTO;
import com.example.tobi.mypage.service.MyPageUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:7007")  // 프론트가 실행되는 주소와 포트를 명시
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageUserService myPageUserService;




    @PostMapping("/check-id")
    public Boolean checkUserId(@RequestBody CheckUserIdDTO checkUserIdDTO) {

        return myPageUserService.checkId(checkUserIdDTO.getUserId());  // 아이디 틀리면 401 응답

    }

    @GetMapping("/{userId}/nickname")
    public ResponseEntity<String> getNickname(@PathVariable String userId) {
        String nickname = myPageUserService.getNicknameByUserId(userId);
        return ResponseEntity.ok(nickname);
    }


    @PatchMapping("/update-nickname")  // 닉네임 업데이트 API
    public void updateNickname(@RequestBody UpdateNicknameDTO updateNicknameDTO) {
        myPageUserService.updateNickname(updateNicknameDTO.getUserId(), updateNicknameDTO.getNickname());  // 닉네임 변경
    }



}
