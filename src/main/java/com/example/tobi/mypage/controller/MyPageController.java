package com.example.tobi.mypage.controller;

import com.example.tobi.mypage.dto.CheckNicknameDTO;
import com.example.tobi.mypage.dto.CheckUserIdDTO;
import com.example.tobi.mypage.dto.UpdateNicknameDTO;
import com.example.tobi.mypage.service.MyPageUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:7007")  // 프론트가 실행되는 주소와 포트를 명시
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageUserService myPageUserService;

    // 아이디 확인 및 닉네임 가져오기
    @PostMapping("/check-id-and-fetch-nickname")
    public ResponseEntity<?> checkIdAndFetchNickname(@RequestBody CheckUserIdDTO checkUserIdDTO) {
        String userId = checkUserIdDTO.getUserId();

        // 아이디 유효성 검사 및 닉네임 가져오기
        boolean isValid = myPageUserService.isValidUserId(userId);

        if (!isValid) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않은 아이디입니다.");
        }

        String nickname = myPageUserService.fetchNicknameByUserId(userId);

        if (nickname == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("닉네임을 가져오는 데 실패했습니다.");
        }
        UpdateNicknameDTO build = UpdateNicknameDTO.builder().nickname(nickname).userId(userId).build();
        // 유효한 아이디와 닉네임을 반환
        return ResponseEntity.ok(build);
    }

    @PostMapping("/check-nickname")
    public ResponseEntity<?> checkNickname(@RequestBody CheckNicknameDTO checkNicknameDTO) {
        String nickname = checkNicknameDTO.getNickname();

        boolean isDuplicate = myPageUserService.checkNicknameExists(nickname);

        return ResponseEntity.ok(isDuplicate);
    }
    // 닉네임을 통한 수정
    @PostMapping("/update-nickname")
    public ResponseEntity<?> updateNickname(@RequestBody UpdateNicknameDTO updateNicknameDTO) {
        System.out.println("Controller 전달 닉네임: " + updateNicknameDTO.getNickname());

        boolean success = myPageUserService.updateNicknameByNickname(updateNicknameDTO);
        System.out.println("닉네임 변경 성공 여부: " + success);
        if (success) {
            return ResponseEntity.ok("닉네임이 성공적으로 수정되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("닉네임 수정에 실패했습니다.");
        }
    }

}
