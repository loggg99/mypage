package com.example.tobi.mypage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 요청에 대해
                .allowedOrigins("http://localhost:7007")  // 허용할 프론트 엔드 URL
                .allowedMethods("GET", "POST", "PATCH", "DELETE")  // 허용할 HTTP 메서드
                .allowCredentials(true)  // 자격 증명 허용
                .allowedHeaders("*");  // 모든 헤더 허용


    }
}
