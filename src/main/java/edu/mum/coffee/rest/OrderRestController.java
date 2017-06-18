package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@RestController
public class OrderRestController {
	
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public List<Order> getAll(){
		
		return orderService.findAll();
	}
	
	
	
	@RequestMapping(value="/order/add",method=RequestMethod.POST)
	public Order add(@RequestBody Order order){
		
      return orderService.save(order);
		
	}
	
	@RequestMapping(value="/order/delete/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id){
		
		
		Order order=new Order();
		
		if(order!=null){
			
			orderService.delete(order);
		}
	}
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.GET)
	public Order findById(@PathVariable int id){
		
		return orderService.findById(id);
		
	}

}
