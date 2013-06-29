package de.gammas.JfaceGenericsTest.model;

import java.util.Date;

public class Person {

	private String name;
	private Date birthdate;

	
	public Person(String name, Date birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
