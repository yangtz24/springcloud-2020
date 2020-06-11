package com.ytz.springcloud.controller;

import com.ytz.springcloud.common.CommonResult;
import com.ytz.springcloud.entities.Payment;
import com.ytz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            log.info("element: " + service);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" +
                    instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }
}
