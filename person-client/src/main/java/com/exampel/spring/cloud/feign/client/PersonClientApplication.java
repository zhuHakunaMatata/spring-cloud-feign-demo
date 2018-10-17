package com.exampel.spring.cloud.feign.client;

import com.exampel.spring.cloud.feign.api.service.PersonService;
import com.exampel.spring.cloud.feign.client.ribbon.MyLoadBanlanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * Created by kyle on 2018/10/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(clients= PersonService.class)
public class PersonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class,args);
    }

    @Bean
    public MyLoadBanlanceRule myLoadBanlanceRule(){
        return new MyLoadBanlanceRule();
    }

}
