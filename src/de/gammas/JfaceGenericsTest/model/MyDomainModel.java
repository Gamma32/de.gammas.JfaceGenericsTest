package de.gammas.JfaceGenericsTest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDomainModel {
	private Person[] roots;

	public MyDomainModel() {
		Person hubert = new Person("Hubert", new Date());
		roots = new Person[] { hubert };

		Person walli = new Person("Walli", new Date());
		hubert.addChildren(walli);

		Person ulli = new Person("Ulli", new Date());
		hubert.addChildren(ulli);

		Person werner = new Person("Werner", new Date());
		hubert.addChildren(werner);

		Person laura = new Person("Laura", new Date());
		werner.addChildren(laura);

		Person hendrik = new Person("Hendrik", new Date());
		werner.addChildren(hendrik);
	}
	
	public Person[] getRoot(){
		return roots;
	}
	
	public List<Person> getFlatList(){
		List<Person> flatPersons = new ArrayList<Person>();
		flatTree(roots, flatPersons);
		return flatPersons;
	}
	
	
	private void flatTree(Object[] persons, List<Person> flatPersons){
		for (int i = 0; i < persons.length; i++) {
			Person person = (Person) persons[i];
			flatPersons.add(person);
			if(person.getChildren() != null){
				flatTree(person.getChildren().toArray(),flatPersons);
			}
		}
	}
}
