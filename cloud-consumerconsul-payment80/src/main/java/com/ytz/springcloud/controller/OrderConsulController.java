package com.ytz.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/13
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/consul/order")
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    /**
     * http://localhost/consumer/payment/zk
     *
     * @return
     */
    @GetMapping("consumer/payment")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/rest/consul/payment/consul", String.class);
    }
}
