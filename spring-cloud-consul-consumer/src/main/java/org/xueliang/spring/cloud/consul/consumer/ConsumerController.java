package org.xueliang.spring.cloud.consul.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String index() {
        String clientName = "spring-cloud-consul-client";
        ServiceInstance serviceInstance = loadBalancerClient.choose(clientName);
        String url = String.format("http://%s:%s/api/client", serviceInstance.getHost(), serviceInstance.getPort());
        System.out.println("url=" + url);
        return "Data From Consumer : " + restTemplate.getForObject(url, String.class);
    }
}
