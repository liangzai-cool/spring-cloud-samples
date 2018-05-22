package org.xueliang.spring.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConfigClientController {

    @Value("${smtp.host}")
    private String smtpHost;

    @GetMapping("/smtp/host")
    public String getSmtpHost(){
        return this.smtpHost;
    }
}