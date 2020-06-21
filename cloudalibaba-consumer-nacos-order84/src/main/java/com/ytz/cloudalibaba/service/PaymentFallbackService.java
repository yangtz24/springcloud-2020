package com.ytz.cloudalibaba.service;

import com.ytz.springcloud.common.CommonResult;
import com.ytz.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PaymentFallbackService
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/21
 * @Version: V1.0
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult<>(4444, "fallback---服务降级返回");
    }
}
