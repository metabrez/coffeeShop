package edu.mum.coffee.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;

@Controller
@SessionAttributes
public class TestAPIController {
	
	 public static final String REST_SERVICE_URI = "http://localhost:8080";
	    @RequestMapping(value="/testAPI", method=RequestMethod.GET)
	    public String getAll(Model model){
	        
	        // Get Orders List
	        RestTemplate restTemplateOrder = new RestTemplate();
	        Order[] orders = restTemplateOrder.getForObject(REST_SERVICE_URI+"/orderWS/", Order[].class);
	        model.addAttribute("orders",Arrays.asList(orders));
	        
	        // Get Persons List 
	        RestTemplate restTemplatePerson = new RestTemplate();
	        Person[] persons = restTemplatePerson.getForObject(REST_SERVICE_URI+"/personWS/", Person[].class);
	        model.addAttribute("persons",Arrays.asList(persons));
	        
	        // Get Products List
	        RestTemplate restTemplateProduct = new RestTemplate();
	        Product[] products = restTemplateProduct.getForObject(REST_SERVICE_URI+"/productWS/", Product[].class);
	        model.addAttribute("products",Arrays.asList(products));
	        
	        return "/testAPI/lists";
	             
	    }
	    //==========================================================================================================================
	    //Get Add Order Form
	    @RequestMapping(value="/testAPI/orders", method=RequestMethod.GET)
	     public String getOrder(Model model){
	         
	         return "/testAPI/addOrder";
	     }
	     
	     //Create order
	    @RequestMapping(value="/testAPI/orders", method=RequestMethod.POST)
	    public String createOrder(@ModelAttribute Order order){
	        RestTemplate restTemplate = new RestTemplate();
	        
	        restTemplate.postForLocation(REST_SERVICE_URI+"/orderWS/", order, Order.class);
	        return "redirect:/testAPI";
	             
	    }
	    
	    //Get Add person page
	    @RequestMapping(value="/testAPI/persons", method=RequestMethod.GET)
	     public String getPerson(Model model){
	               
	         return "/testAPI/addPerson";
	     }
	     
	     // Adding person
	    @RequestMapping(value="/testAPI/persons", method=RequestMethod.POST)
	    public String createPerson(Person person){
	        RestTemplate restTemplate = new RestTemplate();
	        
	        restTemplate.postForLocation(REST_SERVICE_URI+"/personWS/", person, Person.class);
	        return "redirect:/testAPI";
	             
	    }
	    // get Person details
	    @RequestMapping(value="/testAPI/persons/{id}", method=RequestMethod.GET)
	        public String getUpdatePerson(@PathVariable int id,Model model){
	        RestTemplate restTemplate = new RestTemplate();
	        Person person = restTemplate.getForObject(REST_SERVICE_URI+"/personWS/"+id, Person.class);
	        model.addAttribute("person",person);
	        return "/testAPI/personDetail";
	             
	    }
	    // update Person
	    @RequestMapping(value="/testAPI/persons/{id}", method=RequestMethod.POST)
	        public String updatePerson(@PathVariable int id,@ModelAttribute Person person){
	        RestTemplate restTemplate = new RestTemplate();
	        
	        restTemplate.put(REST_SERVICE_URI+"/personWS/"+id, person, Person.class);
	        return "redirect:/testAPI";
	             
	    }
	    
	    
	    
	    //Get Add Product page
	    @RequestMapping(value="/testAPI/products", method=RequestMethod.GET)
	     public String getProduct(Model model){
	               
	         return "/testAPI/addProduct";
	     }
	     
	     // Adding product
	    @RequestMapping(value="/testAPI/products", method=RequestMethod.POST)
	    public String createPerson(Product product){
	        RestTemplate restTemplate = new RestTemplate();
	        
	        restTemplate.postForLocation(REST_SERVICE_URI+"/productWS/", product, Product.class);
	        return "redirect:/testAPI";
	             
	    }
	    // get product details
	    @RequestMapping(value="/testAPI/products/{id}", method=RequestMethod.GET)
	    public String getUpdateProduct(@PathVariable int id,Model model){
	        RestTemplate restTemplate = new RestTemplate();
	        Product product = restTemplate.getForObject(REST_SERVICE_URI+"/productWS/"+id, Product.class);
	        model.addAttribute("product",product);
	        return "/testAPI/productDetail";
	             
	    }
	    // update product
	    @RequestMapping(value="/testAPI/products/{id}", method=RequestMethod.POST)
	    public String updateProduct(@PathVariable int id,Product product){
	        RestTemplate restTemplate = new RestTemplate();
	        
	        restTemplate.put(REST_SERVICE_URI+"/productWS/"+id, product, Product.class);
	        return "redirect:/testAPI";
	             
	    }
	    
	    @RequestMapping(value="/testAPI/products/delete/{id}", method=RequestMethod.POST)
	    public String deleteProduct(@PathVariable int id,Product product){
	        RestTemplate restTemplate = new RestTemplate();
	        
	        restTemplate.delete(REST_SERVICE_URI+"/productWS/"+id, product, Product.class);
	        return "redirect:/testAPI";
	             
	    }
	    
	    
	    
	    
	    
	}



