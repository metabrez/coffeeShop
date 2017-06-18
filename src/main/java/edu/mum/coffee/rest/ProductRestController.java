package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product/create",method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product product){
		
		return productService.save(product);
	}
	
	@RequestMapping(value="/product/update/{id}",method=RequestMethod.PUT)
	public Product update(@PathVariable int id,@RequestBody Product product){
		
		return productService.save(product);
	}
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public List<Product> getAll(){
		
		return productService.getAllProduct();
	}
	@RequestMapping(value="/product/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int id){
		
		Product product=productService.getProduct(id);
		
		if(product!=null){
			
			productService.delete(product);
		}
	
	}

}
