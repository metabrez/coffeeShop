package edu.mum.coffee.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("")
	public List<Order> getAllOrder(){
		
		Collection<? extends GrantedAuthority> authorities=SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		boolean isAdmin=authorities.contains(new SimpleGrantedAuthority("ADMIN"));
		
		User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Person person=(Person) (personService.findByEmail(user.getUsername())).get(0);
		
		if(isAdmin){
			
			return orderService.findAll();
		} else{
			
			return orderService.findAll();
		}
	}

	@GetMapping("/view")
	  public ModelAndView homePage(){
		  
		  ModelAndView mav=new ModelAndView("orders");
		  mav.addObject("orders", getAllOrder());
		  
		  return mav;
	  }
	  
	 @PostMapping("")
	  public void create1(@RequestParam Map<String, String> map) {
	    System.out.println(map);
	    Order order=new Order();
	    if(!map.isEmpty()){
	      User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      order.setPerson((Person) (personService.findByEmail(user.getUsername())).get(0));
	      order.setOrderDate(new Date());
	      for (String productId : map.keySet()) {
	        Orderline orderline= new Orderline();
	        orderline.setOrder(order);
	        orderline.setProduct(productService.getProduct(Integer.parseInt(productId)));
	        orderline.setQuantity(Integer.parseInt(map.get(productId)));
	        order.addOrderLine(orderline);
	      }
	      orderService.save(order);
	    }
	  }
	 
	 @DeleteMapping("{/id}")
	 public Order delete(@PathVariable Integer id){
		 
		 Order order=orderService.findById(id);
		 orderService.delete(order);
		 return order;
	 }
	 
	 @PutMapping("")
	 public Order put(Order order){
		 
		 orderService.save(order);
		 
		 return order;
	 }
}
