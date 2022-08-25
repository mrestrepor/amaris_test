package com.microservice.microservice.services.impl;

import com.microservice.microservice.dao.PersonRepository;
import com.microservice.microservice.entities.Person;
import com.microservice.microservice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository profileRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.profileRepository = repository;
    }

    @Override
    public Person addPerson(Person employeeProfile) {
        return getPersonRepository().save(employeeProfile);
    }

    @Override
    public List<Person> getEmployeeProfiles() {
        return getPersonRepository().findAll();
    }

    public PersonRepository getPersonRepository() {
        return profileRepository;
    }
}
