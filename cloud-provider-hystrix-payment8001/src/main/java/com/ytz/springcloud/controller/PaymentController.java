package com.ytz.springcloud.controller;

import com.ytz.springcloud.common.CommonResult;
import com.ytz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/14
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOK(id);
        log.info("*****result:" + result);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("*****result:" + result);
        return result;
    }

    /**
     * 服务熔断
     * http://localhost:8001/rest/payment/circuit/1
     * @param id
     * @return
     */
    @GetMapping("circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("***result:" + result);
        return result;
    }

    /**
     * 测试缓存----添加
     * @return
     */
    @GetMapping("cache/{id}")
    public CommonResult testCache(@PathVariable("id") Long id) {
        paymentService.getCache(id);
        paymentService.getCache(id);
        paymentService.getCache(id);
        return new CommonResult(200, "操作成功");
    }

    /**
     * 测试缓存---移除
     * @param id
     * @return
     */
    @GetMapping("cache/remove/{id}")
    public CommonResult testRmCache(@PathVariable Long id) {
        paymentService.getCache(id);
        paymentService.removeCache(id);
        paymentService.getCache(id);
        return new CommonResult(200, "操作成功");
    }



}
