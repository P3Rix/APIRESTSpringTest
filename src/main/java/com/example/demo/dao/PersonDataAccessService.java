package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	
	@Override
	public Optional<Person> getOneById(UUID id) {
		return people.stream().filter(person -> person.getId().equals(id)).findFirst();
	}
	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		getOneById(person.getId()).map(p -> {
			int index = people.indexOf(person);
			if(index >= 0) {
				people.set(index, person);
				return 1;
			}
			return 0;
		}).orElse(0);
	}
	@Override
	public void deletePerson(UUID id) {
		// TODO Auto-generated method stub
		getOneById(id).map(p -> {
			int index = people.indexOf(p);
			if(index >= 0) {
				people.remove(index);
				return 1;
			}
			return 0;
		}).orElse(0);
	}

}
