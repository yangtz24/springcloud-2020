package com.ytz.springcloud.controller;

import cn.hutool.core.util.ObjectUtil;
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
        if (result > 0) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed("创建失败");
        }
    }

    @GetMapping("{id}")
    public CommonResult<Payment> getOne(@PathVariable Long id) {
        System.out.println("-****************" + port);
        Payment payment = paymentService.getPaymentById(id);
        if (ObjectUtil.isNotEmpty(payment)) {
            return CommonResult.success(payment, "查询成功,serverPort-->" + port);
        }
        return CommonResult.failed("没有对应记录,查询ID: " + id);
    }

    @GetMapping("lb")
    public String getPaymentLB() {
        return port;
    }
}
