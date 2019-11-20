package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("personDao")
public class PersonDataAccessService implements PersonDao{
	
	private static List<Person> people = new ArrayList();
	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		people.add(new Person(id, person.getName()));
		return 0;
	}
	@Override
	public List<Person> showAllPeople() {
		return people;
	}

}
