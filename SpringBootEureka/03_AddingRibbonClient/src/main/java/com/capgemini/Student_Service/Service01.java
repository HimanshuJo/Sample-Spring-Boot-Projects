package com.capgemini.Student_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RibbonClient(name="service-two")
public class Service01 {

    public static void main(String[] args){
        SpringApplication.run(Service01.class, args);
    }

    @Autowired
    private MountainDAO dao;

    @RequestMapping("/")
    public String index(){
        System.out.println();
        System.out.println("******* ------- ******* ------- ******* ------- HELLO ******* ------- ******* ------- ******* -------");
        System.out.println();
        return "This is a Spring Boot application";
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mountain get(@PathVariable("id") Long id){
        System.out.println();
        Mountain c=dao.get(id);
        String url="http://service-two/{id}";
        String str=this.restTemplate().getForObject(url, String.class, id);
        c.setFirstAscent(str);
        System.out.println("******* ------- ******* ------- ******* ------- HELLO from dao method call ******* ------- ******* ------- ******* -------");
        System.out.println();
        return c;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
}
