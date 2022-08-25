package com.microservice.microservice.services;

import com.microservice.microservice.entities.Person;

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
     * Returns the Person Enity if found by id and idType
     *
     * @param id Person id
     * @param idType Person ID Type
     * @return Optional of Person Entity
     */
    Optional<Person> getPersonByIdAndIdType(String id, String idType);
}
