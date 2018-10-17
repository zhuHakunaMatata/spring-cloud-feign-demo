package com.exampel.spring.cloud.feign.api.service;

import com.exampel.spring.cloud.feign.api.domain.Person;
import com.exampel.spring.cloud.feign.api.hystrix.PersonServiceFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * {@link com.exampel.spring.cloud.feign.api.domain.Person}
 * Created by kyle on 2018/10/16.
 */
@FeignClient(value="person-service",fallback = PersonServiceFallback.class)
public interface PersonService {

    @PostMapping("/person/save")
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "1")
            }
    )
    boolean save(@RequestBody Person person);

    @GetMapping("/person/find/all")
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "1")
            }
    )
    Collection<Person> findAll();

}
