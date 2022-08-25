package com.microservice.microservice.controller;

import com.microservice.microservice.dto.PersonDTO;
import com.microservice.microservice.entities.Person;
import com.microservice.microservice.services.PersonService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(value = "/getPersons", params = {"id", "idType"})
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public ResponseEntity<?> getAllEmployee(@RequestParam String id, @RequestParam String idType) {
        Optional<Person> optionalPerson = getPersonService().getPersonByIdAndIdType(id, idType);
        return optionalPerson.isPresent() ? new ResponseEntity<>(optionalPerson.get(), HttpStatus.OK) : new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    public PersonService getPersonService() {
        return personService;
    }
}
