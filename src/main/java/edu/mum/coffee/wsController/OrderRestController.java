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

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@RestController

public class OrderRestController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PersonService personService;

	@RequestMapping("/orderWS")
	public List<Order> getAll() {
		return orderService.findAll();
	}

	@RequestMapping(value = "/orderWS/{id}", method = RequestMethod.GET)
	public Order findById(@PathVariable int id) {
		return orderService.findById(id);
	}

	@RequestMapping(value = "/orderWS", method = RequestMethod.POST)
	public Order Add(@RequestBody Order order) {
		return orderService.save(order);
	}
}
