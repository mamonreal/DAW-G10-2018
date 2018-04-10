package com.daw.apimeals.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.menu.MenuRepository;
import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;


@RestController
@RequestMapping("/api")
public class AdminRestController {
	
	@Autowired 
	private MenuRepository mRepository;
	
	@Autowired 
	private ProductRepository pRepository;
	
	
	@RequestMapping("/menu/")
	public List<Menu> getMenus() {
		return mRepository.findAll();
	}
	
	@RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Menu> deleteMenu(@PathVariable long id) {
		Menu menu = mRepository.getOne(id);
		mRepository.delete(id);

		if (menu != null) {
			return new ResponseEntity<>(menu, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/*@RequestMapping("/plates")
	public List<Product> getProducts() {
		return pRepository.findAll();
	}*/
	
	@RequestMapping(value = "/plates/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
		Product product = pRepository.getOne(id);
		pRepository.delete(id);

		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/menu",method = RequestMethod.POST)
	public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
		Menu newMenu = mRepository.save(menu);
		return new ResponseEntity<>(newMenu,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/plates",method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = pRepository.save(product);
		return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
	}
	
}

