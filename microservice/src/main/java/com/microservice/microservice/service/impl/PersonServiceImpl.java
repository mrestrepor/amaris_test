package com.microservice.microservice.service.impl;

import com.microservice.microservice.dao.PersonRepository;
import com.microservice.microservice.entities.Person;
import com.microservice.microservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository profileRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.profileRepository = repository;
    }

    @Override
    public Person addEmployeeProfile(Person employeeProfile) {
        return getProfileRepository().save(employeeProfile);
    }

    @Override
    public List<Person> getEmployeeProfiles() {
        return getProfileRepository().findAll();
    }

    public PersonRepository getProfileRepository() {
        return profileRepository;
    }
}
