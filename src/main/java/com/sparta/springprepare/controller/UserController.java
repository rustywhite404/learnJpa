package com.sparta.springprepare.controller;

import com.sparta.springprepare.dto.LoginRequestDto;
import com.sparta.springprepare.dto.SignupRequestDto;
import com.sparta.springprepare.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String signup(@ModelAttribute SignupRequestDto signupRequestDto){
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login-page";
    }
    @PostMapping("/user/login")
    public String login(LoginRequestDto requestDto, HttpServletResponse res){
        try {
            userService.login(requestDto, res);
        } catch (Exception e) {
           return "redirect:/api/user/login-page?error";
        }

        return "redirect:/";
    }
}