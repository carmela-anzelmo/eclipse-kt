package it.ca.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.ca.demo.dto.MessageDto;
import it.ca.demo.dto.PersonDto;
import it.ca.demo.model.People;
import it.ca.demo.service.PersonService;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/string", produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageDto getDemoString() {
		MessageDto message = new MessageDto();
		message.setMessage("Demo string");
		return message;
	}

	@GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonDto getPerson(@RequestParam int id) {
		PersonDto dto = new PersonDto();
		Optional<People> dao = personService.get(id);

		if (dao.isEmpty()) {
			return dto;
		}

		People person = dao.get();
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setId(person.getId());

		return dto;
	}

	@GetMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonDto> getPeople() {
		List<PersonDto> peopleDto = new ArrayList<>();
		List<People> people = personService.getAll();

		people.forEach(person -> {
			PersonDto dto = new PersonDto();
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setId(person.getId());

			peopleDto.add(dto);
		});

		return peopleDto;
	}
}
