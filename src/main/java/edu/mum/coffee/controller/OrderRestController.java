package edu.mum.coffee.controller;

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

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PersonService personService;

	
	
	   
	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Order> create(@RequestBody Order order) {
	        order = orderService.save(order);
	        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Order>> retrieveAll() {
	        List<Order> orders = orderService.findAll();
	        if (orders.isEmpty()) {
	            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Order> retrieve(@PathVariable int id) {
	        Order existingOrder = orderService.findById(id);

	        if (existingOrder == null) {
	            return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<Order>(existingOrder, HttpStatus.OK);
	    }

	    @RequestMapping(value = "/find", method = RequestMethod.GET)
	    public ResponseEntity<List<Order>> retrieveByPersonEmail(@PathParam("email") String email) {
	        String decoded = URLDecoder.decode(email);
	        List<Order> orders = null;
	        List<Person> person = personService.findByEmail(decoded);
	        for (Person person2 : person) {
	             orders = orderService.findByPerson(person2);
	            if (orders.isEmpty()) {
	                return new ResponseEntity<List<Order>>(orders, HttpStatus.NO_CONTENT);
	            }  
			}
	        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.PUT)
	    public ResponseEntity<Void> update(@RequestBody Order order) {
	        Order existingOrder = orderService.findById(order.getId());

	        if (existingOrder == null) {
	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	        } else {
	            orderService.save(order);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
	        Order placedOrder = orderService.findById(id);
	        if (placedOrder == null) {
	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	        } else {
	            orderService.delete(placedOrder);
	            return new ResponseEntity<Void>(HttpStatus.GONE);
	        }
	    }}
	
