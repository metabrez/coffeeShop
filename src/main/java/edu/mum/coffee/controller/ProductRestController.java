package edu.mum.coffee.controller;

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
@RequestMapping("/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	 @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Product> create(@RequestBody Product product) {
	        product = productService.save(product);
	        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Product>> retrieveAll() {
	    	 List<Product> products = productService.getAllProduct();
	        if (products.isEmpty()) {
	            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Product> retrieve(@PathVariable int id) {
	    	 Product placedProduct = productService.getProduct(id);

	        if (placedProduct == null) {
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Product>(placedProduct, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.PUT)
	    public ResponseEntity<Void> update(@RequestBody Product product) {
	        Product existingProduct = productService.getProduct(product.getId());

	        if (existingProduct == null) {
	            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	        } else {
	            productService.save(product);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
	        Product existingProduct = productService.getProduct(id);
	        if (existingProduct == null) {
	            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	        } else {
	            productService.delete(existingProduct);
	            return new ResponseEntity<Void>(HttpStatus.GONE);
	        }
	    }
	}