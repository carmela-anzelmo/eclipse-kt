package it.ca.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.ca.demo.dao.Person;
import it.ca.demo.dto.MessageDto;
import it.ca.demo.dto.PersonDto;
import it.ca.demo.repository.PersonRepository;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping(value = "/string", produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageDto getDemoString() {
		MessageDto message = new MessageDto();
		message.setMessage("Demo string");
		return message;
	}

	@PostMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void setPerson(@RequestBody PersonDto personDto) {
		Person person = new Person();
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setAge(personDto.getAge());
		personRepository.save(person);
	}

	@GetMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonDto getPerson(@RequestParam String name) {
		PersonDto dto = new PersonDto();
		Optional<Person> dao = personRepository.findById(name);

		if (dao.isEmpty()) {
			return dto;
		}

		Person person = dao.get();
		dto.setFirstName(person.getLastName());

		return dto;
	}
}
