package com.example.jenkins.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173") // doker container port 설정
                .allowedOrigins("http://localhost:30000") // NodePort로 설정 (kubernetes)
                .allowedOrigins("") // Ingress 설정 시 내부 요청이므로 cors 설정 불필요
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
