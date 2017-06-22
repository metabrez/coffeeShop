package edu.mum.coffee.wsController;

import java.net.URLDecoder;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    PersonService personService;
	 @RequestMapping(value = "/personWS", method=RequestMethod.GET)
	    public List<Person> getAll(){
	        return personService.getAllPerson();
	    }
	    @RequestMapping(value = "/personWS/{id}", method=RequestMethod.GET)
	    public Person findById(@PathVariable long id){
	        return personService.findById(id);
	    }
	   
	    @RequestMapping(value = "/personWS", method=RequestMethod.POST)
	    public Person Add(@RequestBody Person person){
	        return personService.savePerson(person);
	    }
	    
	    @RequestMapping(value = "/personWS/{id}", method=RequestMethod.PUT)
	    public Person update(@PathVariable long id,@RequestBody Person person){
	        return personService.savePerson(person);
	    }
	    
	  
	    
	}
    
   
	
