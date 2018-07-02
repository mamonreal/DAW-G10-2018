package com.daw.apimeals.product;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.daw.apimeals.product.Product.ProductBassic;
import com.daw.apimeals.user.UserComponent;
import com.fasterxml.jackson.annotation.JsonView;

@RequestMapping(value = "/api")
@RestController
public class ProductRestController {
		
	@Autowired 
	private ProductRepository pRepository;
		
	@Autowired
	UserComponent userComponent;
	
		@JsonView(ProductBassic.class)
		@RequestMapping(value="/Product/{id}", method=RequestMethod.GET)
	    public ResponseEntity<Product>getProduct(@PathVariable long id) {
	    	Product product= pRepository.findById(id);
	    	return new ResponseEntity<>(product,HttpStatus.OK);
	    }

		@JsonView(ProductBassic.class)
	    @RequestMapping(value="/Product/{id}", method=RequestMethod.POST)
	    public ResponseEntity<Product>addProduct( @PathVariable String name,@PathVariable String description, @PathVariable String category, @PathVariable String type, @PathVariable String kc, @PathVariable String price ) {
	    	Product product= new Product(name,description,type, category,Integer.parseInt(kc),"",Long.parseLong(price));
	    	pRepository.save(product);

	    	return new ResponseEntity<>(product,HttpStatus.CREATED);
	    }
	    
		@JsonView(ProductBassic.class)
	    @RequestMapping(value="/Product/{id}", method=RequestMethod.DELETE)
	    public ResponseEntity<Boolean>deleteProduct(@PathVariable long id ) {
	    	Product product = pRepository.findById(id);
	    	pRepository.delete(product);
	    	
	    	return new ResponseEntity<>(true,HttpStatus.OK);
	    }
	    	  
		@JsonView(ProductBassic.class)
		@RequestMapping(value="/Product", method=RequestMethod.GET)
	    public ResponseEntity<List<Product>>getProducts() {
	    	List<Product> product= pRepository.findAll();
	    	return new ResponseEntity<>(product,HttpStatus.OK);
	    }
	}
	    


