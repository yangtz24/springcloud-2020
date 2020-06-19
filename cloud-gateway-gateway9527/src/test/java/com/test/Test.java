package com.test;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/18
 * @Version: V1.0
 */
@SpringBootTest
public class Test {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
