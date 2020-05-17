package com.espark.adarsh.controller;

import com.espark.adarsh.bean.Person;
import com.espark.adarsh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person) {
        return this.personService.savePerson(person);
    }

    @PutMapping("/person/{personId}")
    public Person updatePerson(@PathVariable("personId") Long personId, @RequestBody Person person) {
        return this.personService.updatePerson(personId, person);
    }

    @DeleteMapping("/person/{personId}")
    public Person updatePerson(@PathVariable("personId") Long personId) {
        return this.personService.deletePerson(personId);
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable("personId") Long personId) {
        return this.personService.findPerson(personId);
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return this.personService.findPersons();
    }

}
