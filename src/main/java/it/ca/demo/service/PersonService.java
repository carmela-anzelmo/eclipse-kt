package it.ca.demo.service;

import java.util.List;
import java.util.Optional;

import it.ca.demo.model.People;

public interface PersonService {

	Optional<People> get(Integer id);

	void add(People person);
	
	List<People> getAll();
}
