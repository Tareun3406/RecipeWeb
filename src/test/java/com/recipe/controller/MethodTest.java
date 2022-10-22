package com.recipe.controller;

import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
})
public class MethodTest {

    @Setter(onMethod_ = @Autowired)
    private DataSource ds;

    @Test
    public void randomPW(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        char addChar;
        for (int i = 0; i<10; i++){
            int rndCheck = random.nextInt(3);
            switch (rndCheck){
                case 0: // 대문자
                    addChar= (char)(random.nextInt(26)+65);
                    stringBuilder.append(addChar);
                case 1: // 소문자
                    addChar= (char)(random.nextInt(26)+97);
                    stringBuilder.append(addChar);
                    break;
                case 2: // 숫자
                    stringBuilder.append(random.nextInt(10));
                    break;
            }
        }
        System.out.println(stringBuilder);
    }
}
