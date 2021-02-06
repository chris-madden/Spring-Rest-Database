package com.accela.persondb.service;

import com.accela.persondb.model.Person;
import com.accela.persondb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons()
    {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public Person getPersonById(int id)
    {
        return personRepository.findById(id).get();
    }

    public ResponseEntity<Person> createPerson(Person person)
    {
        if(!personRepository.findById(person.getId()).isPresent())
        {
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Person> updatePerson(Person person)
    {
        if(personRepository.findById(person.getId()).isPresent())
        {
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
        }
    }

    public long countPersons()
    {
        return personRepository.count();
    }

    public void delete(int id)
    {
        personRepository.deleteById(id);
    }
}