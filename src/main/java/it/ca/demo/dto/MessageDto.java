package it.ca.demo.dto;

import java.io.Serializable;

public class MessageDto implements Serializable {

	private static final long serialVersionUID = 4148287236912608306L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
