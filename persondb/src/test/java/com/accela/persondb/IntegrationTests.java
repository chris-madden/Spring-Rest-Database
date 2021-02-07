package com.accela.persondb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.accela.persondb.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class IntegrationTests
{
    @Test
    public void createPersonTest()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/person";

        Person person = new Person("Chris", "Madden");
        restTemplate.postForEntity(url, person, Person.class);

        Person[] persons = restTemplate.getForObject(url, Person[].class);

        assertEquals(persons[0].getFirstName(),"Chris");
        assertEquals(persons[0].getLastName(), "Madden");

    }
}
