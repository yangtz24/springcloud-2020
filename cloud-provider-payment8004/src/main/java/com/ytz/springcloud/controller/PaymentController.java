package com.ytz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName: PaymentController
 * @Description:
 * @author: yangtianzeng
 * @date: 2020/3/19 18:02
 */
@RestController
@RequestMapping("rest/zk/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * http://localhost:8004/payment/zk
     *
     * @return
     */
    @RequestMapping(value = "zk")
    public String paymentZk() {
        return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
