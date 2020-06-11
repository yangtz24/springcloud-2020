package com.ytz.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description:
 * @author: yangtianzeng
 * @date: 2020/3/18 23:02
 */
@RestController
@RequestMapping("hello")
public class TestController {

    @GetMapping("")
    public String test() {
        return "hello";
    }
}
