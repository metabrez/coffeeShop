package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RestController
public class PersonRestController {
	
	@Autowired
	private PersonService personService;

	
	
	@RequestMapping(value="/person/{email}",method=RequestMethod.GET)
	public List<Person> findByEmail(@PathVariable String email){
		
		return personService.findByEmail(email);
	}
	
	@RequestMapping(value="/person/{id}",method=RequestMethod.GET)
	public Person getById(@PathVariable Long id){
		
		return personService.findById(id);
	}
	
	@RequestMapping(value="/person",method=RequestMethod.POST)
	public Person addPerson(@RequestBody Person person){
		
		return personService.savePerson(person);
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id,Person person){
		
		 personService.removePerson(person);
	}
	
}
