package com.exampel.spring.cloud.feign.client.web;

import com.exampel.spring.cloud.feign.api.domain.Person;
import com.exampel.spring.cloud.feign.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by kyle on 2018/10/16.
 */
@RestController
public class PersonClientController {
    private final PersonService personService;

    @Autowired
    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping("/person/find/all")
    public Collection<Person> findAll(){
        return personService.findAll();
    }


}
