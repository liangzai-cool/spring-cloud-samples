package org.xueliang.spring.cloud.eureka.feign.upload.consumer.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class EurekaFeignUploadApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaFeignUploadApplication.class).web(true).run(args);
    }
}
