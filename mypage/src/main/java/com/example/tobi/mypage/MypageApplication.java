package com.example.tobi.mypage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MypageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypageApplication.class, args);
    }

}
