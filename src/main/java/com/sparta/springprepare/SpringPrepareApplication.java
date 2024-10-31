package com.sparta.springprepare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // Spring Security 인증 기능 제외
@SpringBootApplication
public class SpringPrepareApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringPrepareApplication.class, args);
    }

}
