package com.exampel.spring.cloud.feign.person.service.provider.repository;

import com.exampel.spring.cloud.feign.person.service.provider.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kyle on 2018/10/31.
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person,Long>{
}
