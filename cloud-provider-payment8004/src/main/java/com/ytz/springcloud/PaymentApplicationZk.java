package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentApplicationZk
 * @Description: 主启动类
 * @author: yangtianzeng
 * @date: 2020/3/19 17:59
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class PaymentApplicationZk {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationZk.class, args);
    }
}
