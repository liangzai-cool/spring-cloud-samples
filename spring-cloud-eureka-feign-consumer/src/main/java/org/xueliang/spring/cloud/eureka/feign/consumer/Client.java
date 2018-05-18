package org.xueliang.spring.cloud.eureka.feign.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-cloud-eureka-client")
public interface Client {

    @RequestMapping(value = "/api/client", method = RequestMethod.GET)
    String client();
}
