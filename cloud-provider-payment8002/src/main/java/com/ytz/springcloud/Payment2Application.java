
package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: PaymentApplication
 * @Description: 启动类
 * @author: yangtianzeng
 * @date: 2020/3/18 22:56
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment2Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment2Application.class, args);
    }
}
