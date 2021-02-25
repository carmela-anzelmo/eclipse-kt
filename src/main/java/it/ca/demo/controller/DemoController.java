package it.ca.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ca.demo.dto.MessageDto;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping(value = "/string", produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageDto getDemoString() {
		MessageDto message = new MessageDto();
		message.setMessage("Demo string");
		return message;
	}
}
