package com.onnoa.shop.demo.comment.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: fish
 * @Date: 2023/11/19 19:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElkControllerTest.class)
class ElkControllerTest {

    @Test
    public void elk(){
        System.out.println("单元测试类");
    }
}
