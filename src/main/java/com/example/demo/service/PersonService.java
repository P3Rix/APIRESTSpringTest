package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {
	private final PersonDao personDao;
	
	@Autowired
	public PersonService(@Qualifier("personDao") PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public int addPerson(Person person) {
		return personDao.addPerson(person);
	}
	
	public List<Person> showAllPeople() {
		return personDao.showAllPeople();
	}
	
	public Optional<Person> getOneById(UUID id) {
		return personDao.getOneById(id);
	}
	
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}
	
	public void deletePerson(UUID id) {
		personDao.deletePerson(id);
	}
}
