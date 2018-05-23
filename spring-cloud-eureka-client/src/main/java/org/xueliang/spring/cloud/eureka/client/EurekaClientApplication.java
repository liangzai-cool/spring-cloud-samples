package org.xueliang.spring.cloud.eureka.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping("/api")
public class EurekaClientApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }

    @RequestMapping("/client")
    public String client() throws  InterruptedException {
//        Thread.sleep(5000L);  // 用于测试 spring-cloud-eureka-ribbon-hystrix-consumer 模块
        return "Data From Client";
    }
}
