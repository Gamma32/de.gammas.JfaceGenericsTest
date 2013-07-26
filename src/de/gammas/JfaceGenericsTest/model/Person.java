package de.gammas.JfaceGenericsTest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

	private String name;
	private Date birthdate;
	
	private Person father;
	
	private List<Person> children = new ArrayList<Person>();

	
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

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}
	
	public void addChildren(Person children){
		this.children.add(children);
	}
}
