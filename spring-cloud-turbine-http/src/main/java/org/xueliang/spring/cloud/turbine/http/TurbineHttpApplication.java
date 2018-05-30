package org.xueliang.spring.cloud.turbine.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurbineHttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineHttpApplication.class, args);
    }
}
