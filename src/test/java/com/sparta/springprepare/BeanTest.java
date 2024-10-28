package com.sparta.springprepare;

import com.sparta.springprepare.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    //Food food로 주입하려 하면 Food 타입의 bean이 두개 이상이라 안된다고 하므로
    //어떤 bean을 주입할건지 아래처럼 명시해주어야 함.
    //여기서 알 수 있는 점 : @Autowired가 기본적으로는 Bean의 Type(Food)로 DI를 지원하며
    //연결이 되지 않을 경우 Bean name(pizza, chicken)으로 찾는다
    @Autowired
    Food chicken;

    @Autowired
    Food pizza;

    @Test
    @DisplayName("bean 주입 테스트")
    public void beanTest(){
        pizza.eat();
        chicken.eat();
    }
}
