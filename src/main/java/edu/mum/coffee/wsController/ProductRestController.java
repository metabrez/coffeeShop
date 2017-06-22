package edu.mum.coffee.wsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@RequestMapping("/productWS")
    public List<Product> getAll(){
        return productService.getAllProduct();
    }
    
    @RequestMapping(value = "/productWS/{id}", method=RequestMethod.GET)
    public Product findById(@PathVariable int id){
        return productService.getProduct(id);
    }
    
    @RequestMapping(value = "/productWS", method=RequestMethod.POST)
    public Product Add(@RequestBody Product product){
        return productService.save(product);
    }
    
    @RequestMapping(value = "/productWS/{id}", method=RequestMethod.PUT)
    public Product update(@PathVariable int id,@RequestBody Product product){
        return productService.save(product);
    }
    
    @RequestMapping(value = "/productWS/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        Product product = productService.getProduct(id);
        if(product != null)
            productService.delete(product);
    }
       
}
	
	 