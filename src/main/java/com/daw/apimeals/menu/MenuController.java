package com.daw.apimeals.menu;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daw.apimeals.product.Product;

@Controller
public class MenuController {
	
	@Autowired 
	private MenuRepository mRepository;
	
	
	@PostConstruct
	public void init() {
		Menu m1,m2,m3;
		m1=new Menu(1,"Veggie","Vegano","Menu vegano","lunch","306","",12);
		m2=new Menu(2,"Mediterranean","Mediterraneo","Desayuno mediterraneo","breakfast","44","",12);
		m3=new Menu(3,"American","Americano","Cena americana","dinner","306","",12);
		
		mRepository.save(m1);
		mRepository.save(m2);
		mRepository.save(m3);
	}
	
	
	
	@RequestMapping("/menu")
	public String menus(Model model, HttpServletRequest request) {
		
		List<Menu> breakfast = mRepository.findBycategory("breakfast");
		List<Menu> lunch = mRepository.findBycategory("lunch");
		List<Menu> dinner = mRepository.findBycategory("dinner");
		
		model.addAttribute("breakfast", breakfast);
		model.addAttribute("lunch", lunch);
		model.addAttribute("dinner", dinner);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		return "menu";
	}

}
