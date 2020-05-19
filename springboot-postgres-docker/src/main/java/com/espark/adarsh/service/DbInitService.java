package com.espark.adarsh.service;

import com.espark.adarsh.bean.Person;
import com.espark.adarsh.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInitService {

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Person adarsh = new Person();
        adarsh.setFirstName("adarsh");
        adarsh.setLastName("kumar");
        personRepository.save(adarsh);
        Person radha = new Person();
        radha.setFirstName("radha");
        radha.setLastName("singh");
        personRepository.save(radha);
    }

}
