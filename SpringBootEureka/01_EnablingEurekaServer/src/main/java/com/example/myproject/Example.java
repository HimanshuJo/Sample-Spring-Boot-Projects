package com.example.myproject;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaServer
public class Example{
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Example.class, args);
    }
}