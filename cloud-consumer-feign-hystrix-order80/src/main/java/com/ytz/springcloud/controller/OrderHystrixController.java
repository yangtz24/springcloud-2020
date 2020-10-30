package com.ytz.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.ytz.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderHystrixController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/14
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/order")
@Slf4j
// @DefaultProperties：全局的服务降级处理
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * 正常访问
     * http://localhost/consumer/payment/hystrix/ok/32
     *
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOK(id);
    }

    /**
     * 超时访问
     * http://localhost/consumer/payment/hystrix/timeout/32
     *
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    //@HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        //int num = 10/0;
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    /**
     * 超时方法fallback
     *
     * @param id
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 全局fallback
     *
     * @return
     */
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }
}
