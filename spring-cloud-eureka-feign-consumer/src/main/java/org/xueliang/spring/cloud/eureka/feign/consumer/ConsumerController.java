package org.xueliang.spring.cloud.eureka.feign.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", method  = RequestMethod.GET)
public class ConsumerController {

    @Autowired
    private Client client;

    @GetMapping("/consumer")
    public String consumer() {
        return "Data From FeignConsumer : " + client.client();
    }
}
