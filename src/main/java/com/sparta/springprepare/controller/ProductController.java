package com.sparta.springprepare.controller;

import com.sparta.springprepare.entity.User;
import com.sparta.springprepare.entity.UserRoleEnum;
import com.sparta.springprepare.security.UserDetailsImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        //Authentication의 Principal 부분이 userDetails에 들어가있으므로 가져와보기
        User user = userDetails.getUser();
        System.out.println("user.getUsername() = " + user.getUsername());
        System.out.println("user.getEmail() = " + user.getEmail());

        return "redirect:/";
    }

    @Secured(UserRoleEnum.Authority.ADMIN) // 관리자용
    @GetMapping("/products/secured")
    public String getProductsByAdmin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("userDetails.getUsername() = " + userDetails.getUsername());
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            System.out.println("authority.getAuthority() = " + authority.getAuthority());
        }

        return "redirect:/";
    }
}