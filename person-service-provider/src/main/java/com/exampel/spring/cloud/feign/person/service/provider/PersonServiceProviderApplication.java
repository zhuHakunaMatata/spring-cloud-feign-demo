package com.exampel.spring.cloud.feign.person.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by kyle on 2018/10/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PersonServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceProviderApplication.class,args);
    }
}
