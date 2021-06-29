package com.espark.adarsh.repository;

import java.util.List;

import com.espark.adarsh.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Cacheable("findByPesel")
    public List<Person> findByPesel(String pesel);

}