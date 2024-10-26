package com.sparta.springprepare.controller;

import com.sparta.springprepare.entity.Star;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// @RestController를 사용하면 해당 클래스의 모든 메서드에 @ResponseBody 애너테이션이 추가되는 효과를 부여할 수 있다.
// 즉, @Controller + @ResponseBody
//@RequestMapping("/api")
public class HelloController {

    private static long visitCount = 0;

    @GetMapping("/response/json/string")
    @ResponseBody
    public String helloStringJson() {
    //JSON 형태의 반환값 String
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    @GetMapping("/response/json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("Robbie", 95, null);
    }

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/html/redirect")
    public String htmlStatic() {
        return "redirect:/hi.html";
    }

    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
    }
    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "GET Method 요청";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "POST Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "PUT Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Method 요청";
    }
}