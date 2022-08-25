package com.microservice.microservice.services;

import com.microservice.microservice.entities.Person;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    /**
     * Creates a new employee profile
     *
     * @param employeeProfile - Employee Profile to be created
     * @return created employee profile
     */
    Person addPerson(Person employeeProfile);

    /**
     * @return List of employee profiles
     */
    List<Person> getEmployeeProfiles();
}
