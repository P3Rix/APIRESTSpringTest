package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {
	
	int insertPerson(UUID id, Person person);
	
	default int addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> showAllPeople();
	
	Optional<Person> getOneById(UUID id);
	
	void updatePerson(Person person);
	
	void deletePerson(UUID id);
}
