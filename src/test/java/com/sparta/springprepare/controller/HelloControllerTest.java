package com.sparta.springprepare.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springprepare.entity.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {
    @Test
    @DisplayName("Object to JSON")
    void test1() throws JsonProcessingException{
        Star star = new Star("은주",20, null);

        ObjectMapper objectMapper = new ObjectMapper(); //Jackson라이브러리
        String json = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(star);
        //writeValueAsString파라미터에 JSON으로 변환시킬 오브젝트의 객체를 전달
        System.out.println("json="+json);
    }

    @Test
    @DisplayName("JSON to Object: 기본생성자, getter or setter 필요")
    void test2() throws JsonProcessingException{
        String json = "{\"name\":\"은주\",\"address\":20}"; //JSON 형태의 String
        ObjectMapper objectMapper = new ObjectMapper();
        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName()="+star.getName());
        System.out.println("star.getAge()="+star.getAge());
        System.out.println("star.getAddress()="+star.getAddress());
    }

}