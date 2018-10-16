package com.exampel.spring.cloud.feign.client;

import com.exampel.spring.cloud.feign.api.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by kyle on 2018/10/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients= PersonService.class)
public class PersonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class,args);
    }
}
