package org.xueliang.spring.cloud.eureka.feign.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaFeignApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaFeignApplication.class).web(true).run(args);
    }
}
