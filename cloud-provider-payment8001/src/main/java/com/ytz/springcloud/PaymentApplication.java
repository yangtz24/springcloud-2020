/**
 * Copyright © 2019 国网信通产业集团. All rights reserved.
 *
 * @Title:PaymentApplication.java
 * @Prject: com.ytz.springcloud
 * @Package: com.ytz.springcloud
 * @author: yangtianzeng
 * @date: 2020/3/18 22:56
 * @version: V1.0
 */
package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: PaymentApplication
 * @Description: 启动类
 * @author: yangtianzeng
 * @date: 2020/3/18 22:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
