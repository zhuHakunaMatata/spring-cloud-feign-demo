package com.exampel.spring.cloud.feign.person.service.provider.web;

import com.exampel.spring.cloud.feign.api.domain.Person;
import com.exampel.spring.cloud.feign.api.service.PersonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by kyle on 2018/10/16.
 */
@RestController
public class PersonServiceController implements PersonService{

    ConcurrentMap<Long,Person> persons = new ConcurrentHashMap<Long,Person>();

    @Override
    //@PostMapping("/person/save")
    public boolean save(@RequestBody Person person){
        return persons.put(person.getId(),person)==null;
    }

    @Override
    //@GetMapping("/person/find/all")
    @HystrixCommand(fallbackMethod = "fallbackForfindAll",
        commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")
        }
    )
    public Collection<Person> findAll() throws InterruptedException {
        Integer random = new Random().nextInt(200);
        System.err.println("----------- sleep time : " + random);
        Thread.sleep(random);
        return persons.values();
    }

    private Collection<Person> fallbackForfindAll(){
        System.err.println("------------ now circuit breaker happers : jump into fallbackForfindAll() ");
        return persons.values();
    }

}
