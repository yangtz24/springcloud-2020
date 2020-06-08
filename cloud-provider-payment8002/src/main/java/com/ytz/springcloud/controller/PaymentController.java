/**
 * Copyright © 2019 国网信通产业集团. All rights reserved.
 *
 * @Title:PaymentController.java
 * @Prject: com.ytz.springcloud.controller
 * @Package: com.ytz.springcloud.controller
 * @author: yangtianzeng
 * @date: 2020/3/18 13:50
 * @version: V1.0
 */
package com.ytz.springcloud.controller;

import com.ytz.springcloud.common.CommonResult;
import com.ytz.springcloud.entities.Payment;
import com.ytz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: PaymentController
 * @Description: 支付控制层
 * @author: yangtianzeng
 * @date: 2020/3/18 13:50
 */
@RestController
@RequestMapping("rest/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if(result > 0) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed("创建失败");
        }
    }

    @GetMapping("{id}")
    public CommonResult<Payment> getOne(@PathVariable Long id) {
        System.out.println("-****************" + port);
        Payment payment = paymentService.getPaymentById(id);
        return CommonResult.success(payment);
    }
}
