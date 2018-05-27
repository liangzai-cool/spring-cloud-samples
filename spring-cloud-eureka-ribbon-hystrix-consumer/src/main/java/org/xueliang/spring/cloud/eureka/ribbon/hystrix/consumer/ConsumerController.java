package org.xueliang.spring.cloud.eureka.ribbon.hystrix.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumer")
    public String consumer() {
        return consumerService.consumer();
    }

    @Service
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod =  "fallback")
        public String consumer() {
            String clientName = "spring-cloud-eureka-client";
            return "Data From RibbonEurekaConsumer : " + restTemplate.getForObject("http://" + clientName + "/api/client", String.class);
        }

        public String fallback() {
            return "Data From Consumer's fallback Method";
        }
    }
}
