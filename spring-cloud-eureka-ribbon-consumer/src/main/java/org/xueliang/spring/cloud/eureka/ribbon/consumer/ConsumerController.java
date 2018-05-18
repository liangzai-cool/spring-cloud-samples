package org.xueliang.spring.cloud.eureka.ribbon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer() {
        String clientName = "spring-cloud-eureka-client";
        return "Data From RibbonEurekaConsumer : " + restTemplate.getForObject("http://" + clientName + "/api/client", String.class);
    }
}
