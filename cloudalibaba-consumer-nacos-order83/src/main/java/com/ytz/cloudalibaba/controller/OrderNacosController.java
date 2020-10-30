package com.ytz.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: OrderNacosController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/order")
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverUrl + "/rest/payment/nacos/" + id, String.class);
    }
}
