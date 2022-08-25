package com.microservice.microservice.controller;

import com.microservice.microservice.dto.PersonDTO;
import com.microservice.microservice.entities.Person;
import com.microservice.microservice.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/")
public class PersonController {

    final PersonService employeeProfileService;

    @Autowired
    public PersonController(PersonService employeeProfileService) {
        this.employeeProfileService = employeeProfileService;
    }

    @RequestMapping(value = "/persons")
    @PostMapping
    public ResponseEntity<?> saveEmployeeProfile(@Valid @RequestBody PersonDTO employeeProfileDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Person employeeProfile = getEmployeeProfileService().addEmployeeProfile(modelMapper.map(employeeProfileDTO, Person.class));
        return new ResponseEntity<>(employeeProfile, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getPersons")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Person> getAllEmployee() {
        return getEmployeeProfileService().getEmployeeProfiles();
    }

    public PersonService getEmployeeProfileService() {
        return employeeProfileService;
    }
}
