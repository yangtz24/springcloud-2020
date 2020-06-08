/**
 * Copyright © 2019 国网信通产业集团. All rights reserved.
 *
 * @Title:TestController.java
 * @Prject: com.ytz.springcloud.controller
 * @Package: com.ytz.springcloud.controller
 * @author: yangtianzeng
 * @date: 2020/3/18 23:02
 * @version: V1.0
 */
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
