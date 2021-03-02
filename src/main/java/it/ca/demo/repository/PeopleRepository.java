package it.ca.demo.repository;

import org.springframework.data.repository.CrudRepository;

import it.ca.demo.model.People;

public interface PeopleRepository extends CrudRepository<People, Integer> {

}
