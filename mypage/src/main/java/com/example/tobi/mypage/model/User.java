package com.example.tobi.mypage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    private int id;
    private String user_id;
    private String email_provider;
    private String name;
    private String password;
    private String nickname;
    private String role;

}
