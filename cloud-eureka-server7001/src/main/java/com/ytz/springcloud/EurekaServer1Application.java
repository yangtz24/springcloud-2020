package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: EurekaApplication
 * @Description: 注册中心启动类
 * @author: yangtianzeng
 * @date: 2020/3/19 14:13
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaServer1Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1Application.class, args);
    }
}
