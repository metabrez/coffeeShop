package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;


@RestController
@RequestMapping(value="/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("")
	public List<Person> homePage(){
		
		return personService.getAllPerson();
	}
	
	@PostMapping("")
	public Person create(Person person){
		
		personService.savePerson(person);
		
		return person;
	}
	
	@DeleteMapping("/{id}")
	public Person delete(@PathVariable Long id){
		
		Person person=personService.findById(id);
		
		personService.removePerson(person);
		
		return person;
	}
	
	
	public Person update(Person person){
		
		personService.savePerson(person);
		
		return person;
	}
	
	

}
