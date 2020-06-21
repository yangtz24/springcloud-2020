package com.ytz.cloudalibaba.service;

import com.ytz.springcloud.common.CommonResult;
import com.ytz.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: PaymentService
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/21
 * @Version: V1.0
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("rest/payment/{id}")
    CommonResult<Payment> payment(@PathVariable("id") Long id);
}
