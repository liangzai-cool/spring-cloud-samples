package org.xueliang.spring.cloud.config.refreshable.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigRefreshableClientApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigRefreshableClientApplication.class).web(true).run(args);
    }
}
