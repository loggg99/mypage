package com.example.tobi.mypage.controller;

import com.example.tobi.mypage.dto.CheckUserIdDTO;
import com.example.tobi.mypage.dto.UpdateNicknameDTO;
import com.example.tobi.mypage.service.MyPageUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
//@RequestMapping("/")
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageUserService myPageUserService;

    @GetMapping("/")
    public String myPage() { return "mypage";
    }

    @GetMapping("/user/idForUpdate")
    public String idForUpdate() {
        return "idForUpdate";
    }


    @PostMapping("/user/check-before-update")
    public ResponseEntity<Void> checkBeforeUpdate(@RequestBody CheckUserIdDTO checkUserIdDTO) {

        boolean isValid = myPageUserService.checkId(checkUserIdDTO.getUserId());
        if (isValid) {
            return ResponseEntity.ok().build();  //아이디 맞으면 ok
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();  // 아이디 틀리면 401 응답
       }
    }


    @PatchMapping("/user/nicknameUpdate")
    public ResponseEntity<String> updateNickname(@RequestBody UpdateNicknameDTO updateNicknameDTO) {
        myPageUserService.newUpdateNicknam(updateNicknameDTO.getId(), updateNicknameDTO.getNickname());
        return ResponseEntity.ok("닉네임이 성공적으로 변경되었습니다.");
    }

}
