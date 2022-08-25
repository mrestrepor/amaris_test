package com.microservice.microservice.dao;

import com.microservice.microservice.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT person FROM Person person WHERE person.id=?1 AND person.idType=?2")
    Person findByIdAndIdType(String id, String idType);
}
