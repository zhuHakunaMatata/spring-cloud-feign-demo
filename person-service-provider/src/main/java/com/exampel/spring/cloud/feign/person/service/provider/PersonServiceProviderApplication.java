package com.exampel.spring.cloud.feign.person.service.provider;

import com.exampel.spring.cloud.feign.api.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;

/**
 * Created by kyle on 2018/10/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@Import(WebConfig.class)
public class PersonServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceProviderApplication.class,args);
    }
}
