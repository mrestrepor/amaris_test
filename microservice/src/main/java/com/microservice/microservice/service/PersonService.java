package com.microservice.microservice.service;

import com.microservice.microservice.entities.Person;

import java.util.List;

public interface PersonService {

    /**
     * Creates a new employee profile
     *
     * @param employeeProfile - Employee Profile to be created
     * @return created employee profile
     */
    Person addEmployeeProfile(Person employeeProfile);

    /**
     * @return List of employee profiles
     */
    List<Person> getEmployeeProfiles();
}
