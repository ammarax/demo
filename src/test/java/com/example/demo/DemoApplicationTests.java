package com.example.demo;

import com.example.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DemoController demoController;

    @Test
    void contextLoads() {
        String content = "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";
        String result = demoController.calcResult(content);
        System.out.print(result);
    }

}
