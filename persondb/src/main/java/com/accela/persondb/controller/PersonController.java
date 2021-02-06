package com.accela.persondb.controller;

import com.accela.persondb.model.Person;
import com.accela.persondb.service.PersonService;
import com.accela.persondb.utils.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    private ResponseEntity<Person> createPerson(@Valid @RequestBody Person person)
    {
        return personService.createPerson(person);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e)
    {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream()
                .map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        return fieldErrorMessages;
    }

    @PutMapping("/person")
    private ResponseEntity<Person> updatePerson(@RequestBody Person person)
    {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person/{id}")
    private void deletePerson(@PathVariable("id") int id)
    {
        personService.delete(id);
    }

}
