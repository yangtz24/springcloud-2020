package com.ytz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/12
 * @Version: V1.0
 */
@RestController
@Slf4j
@RequestMapping("rest/consul/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @return
     */
    @RequestMapping(value = "consul")
    public String paymentConsul() {
        return "SpringCloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
