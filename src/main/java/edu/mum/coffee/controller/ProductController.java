package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public List<Product> homePage(){
		
		return productService.getAllProduct();
	}
	
	@GetMapping("/add")
	public ModelAndView add(){
		
		ModelAndView mav=new ModelAndView("add");
		
		return mav;
	}
	
	 @PostMapping("/add")
	  @PreAuthorize(value = "hasRole('ADMIN')")
	  public ModelAndView crea(Product product) {
	    ModelAndView modelAndView= new ModelAndView("add");
	    productService.save(product);
	    modelAndView.addObject("successMessage", "Product has been saved successfully");
	    return modelAndView;
	  }

	  @PostMapping("")
	  @PreAuthorize(value = "hasRole('ADMIN')")
	  public Product create(Product product) {
	    productService.save(product);
	    return product;
	  }

	  @DeleteMapping("/{id}")
	  @PreAuthorize(value = "hasAuthority('ADMIN')")
	  public Product delete(@PathVariable int  id,Product product) {
	    
		 productService.delete(product);
		 
		 return product;
		 
	    
	    
	  }

	  @PutMapping("")
	  @PreAuthorize(value = "hasAuthority('ADMIN')")
	  public Product put(Product product) {
	    productService.save(product);
	    return product;
	
	  }
}
