package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: EurekaServer2Application
 * @Description: 主入口
 * @author: yangtianzeng
 * @date: 2020/3/19 15:13
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaServer2Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer2Application.class, args);
    }
}
