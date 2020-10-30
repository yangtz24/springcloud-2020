package com.ytz.springcloud.controller;

import com.ytz.springcloud.common.CommonResult;
import com.ytz.springcloud.entities.Payment;
import com.ytz.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ClassName: OrderController
 * @Description: 订单controller
 * @author: yangtianzeng
 * @date: 2020/3/19 9:15
 */
@RestController
@RequestMapping("rest/order")
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * http://localhost/rest/order/consumer/payment/create
     *
     * @param payment
     * @return
     */
    @GetMapping("consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/rest/payment", payment, CommonResult.class);
    }

    /**
     * http://localhost/rest/order/consumer/payment/get/{id}
     *
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/rest/payment/" + id, CommonResult.class);
    }

    /**
     * http://localhost/rest/order/consumer/payment/getEntity/{id}
     *
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable Long id) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/rest/payment/" + id, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("statusCode----->{}", responseEntity.getStatusCode());
            return responseEntity.getBody();
        }
        return new CommonResult<>(444, "操作失败！！！");
    }

    @GetMapping("consumer/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        if (serviceInstance == null) {
            return null;
        }

        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/rest/payment/lb", String.class);

    }

}
