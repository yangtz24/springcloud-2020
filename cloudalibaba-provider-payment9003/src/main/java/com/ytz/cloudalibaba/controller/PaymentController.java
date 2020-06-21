package com.ytz.cloudalibaba.controller;

import cn.hutool.core.util.IdUtil;
import com.ytz.springcloud.common.CommonResult;
import com.ytz.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PaymentController
 * @Description: TODO controller
 * @author: basketBoy
 * @date: 2020/6/21
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long , Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L, IdUtil.simpleUUID()));
        hashMap.put(2L,new Payment(2L, IdUtil.simpleUUID()));
        hashMap.put(3L,new Payment(3L, IdUtil.simpleUUID()));
    }

    @GetMapping("{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200, "from mysql,serverPort:" + serverPort, payment);
    }
}