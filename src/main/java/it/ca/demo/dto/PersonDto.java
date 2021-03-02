package it.ca.demo.dto;

import java.io.Serializable;

public class PersonDto implements Serializable {

	private static final long serialVersionUID = -4646757836729553290L;
	private String firstName;
	private String lastName;
	private int id;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
