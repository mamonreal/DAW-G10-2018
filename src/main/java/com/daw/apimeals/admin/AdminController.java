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


import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.menu.MenuRepository;
import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;


@Controller
public class AdminController {
	
	@Autowired 
	private MenuRepository mRepository;
	
	@Autowired 
	private ProductRepository pRepository;
	
	
	@RequestMapping("/menu/")
	public List<Menu> getMenus() {
		return mRepository.findAll();
	}
	
	@RequestMapping(value = "/menu/{id}", method = RequestMethod.POST)
	public String deleteMenu(@PathVariable long id) {
		Menu menu = mRepository.getOne(id);
		mRepository.delete(id);
		return "/menu";
		
	}

	@RequestMapping(value = "/plates/{id}", method = RequestMethod.POST)
	public  String deleteProduct(@PathVariable long id) {
		Product product = pRepository.getOne(id);
		pRepository.delete(id);
		return "/plates";
	}
	
	@RequestMapping(value="/menu",method = RequestMethod.POST)
	public String addMenu(@RequestBody Menu menu) {
		Menu newMenu = menu; 
		mRepository.save(newMenu);
		return "/menu";
	}
	
	@RequestMapping(value="/plates",method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		Product newProduct = product;
		pRepository.save(newProduct);
		return "/plates";
	}
	
}


