package com.exampel.spring.cloud.feign.person.service.provider.web;

import com.exampel.spring.cloud.feign.api.domain.Person;
import com.exampel.spring.cloud.feign.api.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
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
    public Collection<Person> findAll(){
        return persons.values();
    }
}
