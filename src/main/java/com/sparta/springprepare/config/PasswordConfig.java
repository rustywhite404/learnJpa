package com.sparta.springprepare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //선언1
public class PasswordConfig {

    //비즈니스 로직이 아니면서 공통으로 사용하는 로직이기 때문에 수동으로 Bean 등록
    @Bean //선언2
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //이제 passwordEncoder를 가져가서 의존성 주입하면 BCryptPasswordEncoder()를 사용할 수 있다.
        //BCryptPasswordEncoder 해시 함수를 만들어주는 라이브러리로 현재도 많이 사용되는 강력한 암호화 방식.
    }
}