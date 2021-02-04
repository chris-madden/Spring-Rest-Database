package com.accela.persondb.controller;

import com.accela.persondb.model.Person;
import com.accela.persondb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person")
    private List<Person> getAllPersons()
    {
        return personService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    private Person getPerson(@PathVariable("id") int id)
    {
        return personService.getPersonById(id);
    }

    @GetMapping("/person/count")
    private long countPersons()
    {
        return personService.countPersons();
    }

    @PostMapping("/person")
    private ResponseEntity<Person> createPerson(@RequestBody Person person)
    {
        return personService.create(person);
    }

    @PutMapping("/person")
    private ResponseEntity<Person> updatePerson(@RequestBody Person person)
    {
        return personService.update(person);
    }

    @DeleteMapping("/person/{id}")
    private void deletePerson(@PathVariable("id") int id)
    {
        personService.delete(id);
    }

}
