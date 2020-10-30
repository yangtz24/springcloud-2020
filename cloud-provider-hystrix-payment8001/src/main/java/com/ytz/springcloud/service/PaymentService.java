package com.ytz.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentService
 * @Description: TODO  服务降级案例
 * @author: basketBoy
 * @date: 2020/6/14
 * @Version: V1.0
 */
@Service
@Slf4j
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     * HystrixCommand:一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbckMethod调用类中的指定方法
     * execution.isolation.thread.timeoutInMilliseconds:线程超时时间3秒钟
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        ///int num = 10 / 0;

        int timeNumber = 5;
        try {
            // 暂停5秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfoTimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    /**
     * 服务不可用---服务降级 后 执行的方法
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " 系统繁忙或运行错误,请稍后重试,id:" + id + "\t" + "o(╥﹏╥)o";
    }

    /**
     * 服务熔断
     *     open: 熔断打开，请求不在进行服务调用当前服务
     *     half-open: 熔断半开，部分请求根据规则调用当前服务，如果当前请求成功且符合规则，可以认为当前服务恢复正常，关闭熔断
     *     closed: 熔断关闭，不会对服务进行熔断
     */
    /**
     * 在10秒窗口期中10次请求有6次是请求失败的,断路器将起作用
     *
     * @param id
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreakerfallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    }
    )
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    /**
     * 服务报错：返回处理的方法
     *
     * @param id
     * @return
     */
    public String paymentCircuitBreakerfallback(Integer id) {
        return "id 不能负数,请稍后重试,o(╥﹏╥)o id:" + id;
    }


    /**
     * 缓存测试
     * 注解说明：
     * 1、@CacheResult：开启缓存，默认所有参数作为缓存的 key cacheKeyMethod可以通过返回String类型的方法指定key
     * 2、@CacheKey: 指定缓存的key,可以指定参数或指定参数中的属性值为缓存key.
     * 3、@CacheRemove: 移除缓存，需要指定commandKey.
     *
     * @return
     */
    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandKey = "getCache")
    public String getCache(Long id) {
        log.info("id----->{}", id);

        return "SUCCESS";
    }

    /**
     * 生成缓存 key
     *
     * @param id
     * @return
     */
    public String getCacheKey(Long id) {
        return String.valueOf(id);
    }

    private String fallbackMethod(Long id) {
        return "查询错误，ID = " + id;
    }

    /**
     * 移除缓存-----
     *
     * @param id
     * @return
     */
    @CacheRemove(commandKey = "getCache", cacheKeyMethod = "getCacheKey")
    @HystrixCommand
    public String removeCache(Long id) {
        log.info("removeCache----id->{}", id);
        return "SUCCESS";
    }
}
