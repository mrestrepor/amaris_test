package com.microservice.microservice.controller;

import com.microservice.microservice.dto.PersonDTO;
import com.microservice.microservice.entities.Person;
import com.microservice.microservice.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/")
public class PersonController {

    final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/persons")
    @PostMapping
    public ResponseEntity<?> saveEmployeeProfile(@Valid @RequestBody PersonDTO employeeProfileDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Person employeeProfile = getPersonService().addPerson(modelMapper.map(employeeProfileDTO, Person.class));
        return new ResponseEntity<>(employeeProfile, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getPersons")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Person> getAllEmployee() {
        return getPersonService().getEmployeeProfiles();
    }

    public PersonService getPersonService() {
        return personService;
    }
}
