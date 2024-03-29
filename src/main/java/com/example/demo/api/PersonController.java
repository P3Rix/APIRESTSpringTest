package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> showAllPeople() {
		return personService.showAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Person getOneById(@PathVariable("id") UUID id) {
		return personService.getOneById(id).orElse(null);
	}
	
	@PutMapping(path = "{id}")
	public void updateperson(@RequestBody Person PersontoUpdate) {
		personService.updatePerson(PersontoUpdate);
	}
	
	@PostMapping(path = "{id}") 
	public void deletePerson(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}
}
