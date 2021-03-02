package it.ca.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ca.demo.model.People;
import it.ca.demo.repository.PeopleRepository;
import it.ca.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PeopleRepository peopleRepo;

	@Override
	public Optional<People> get(Integer id) {
		return peopleRepo.findById(id);
	}

	@Override
	public void add(People person) {
		peopleRepo.save(person);
	}

	@Override
	public List<People> getAll() {
		return StreamSupport.stream(peopleRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
