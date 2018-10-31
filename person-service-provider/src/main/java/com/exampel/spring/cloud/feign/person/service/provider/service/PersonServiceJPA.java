package com.exampel.spring.cloud.feign.person.service.provider.service;

import com.exampel.spring.cloud.feign.person.service.provider.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by kyle on 2018/10/31.
 */
@Service
@Transactional
public class PersonServiceJPA {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public PersonServiceJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean save(Person person){
        this.entityManager.persist(person);
        return true;
    }


}
