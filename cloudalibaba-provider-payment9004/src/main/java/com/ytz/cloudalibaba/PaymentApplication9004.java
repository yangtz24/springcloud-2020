package com.ytz.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentApplication9004
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/21
 * @Version: V1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class PaymentApplication9004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9004.class, args);
    }
}
