package com.exampel.spring.cloud.feign.api.hystrix;

import com.exampel.spring.cloud.feign.api.domain.Person;
import com.exampel.spring.cloud.feign.api.service.PersonService;

import java.util.Collection;

/**
 * Created by kyle on 2018/10/17.
 */
public class PersonServiceFallback implements PersonService {
    @Override
    public boolean save(Person person) {
        System.err.println("---circuit breaker-- save");
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        System.err.println("---circuit breaker-- find all");
        return null;
    }
}
