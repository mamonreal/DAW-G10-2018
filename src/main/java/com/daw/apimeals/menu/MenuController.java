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
		Menu m1,m2,m3,m4,m5,m6,m7,m8;
		m1=new Menu(1,"Veggie","Vegano","Menu vegano","lunch","306","",12);
		m2=new Menu(2,"Mediterranean","Mediterraneo","Desayuno mediterraneo","breakfast","44","",12);
		m3=new Menu(3,"American","Americano","Cena americana","dinner","306","",12);
		m4=new Menu(4,"Sushi","Japones","Bandeja de 12 raciones","dinner","243","",15);
		m5=new Menu(5,"Mexican","Mejicano","Fajita,burrito y nachos","lunch","320","",8);
		m6=new Menu(6,"Menú valenciano","Espanol","Paella valenciana mas entrantes","lunch","356","",13);
		m7=new Menu(7,"Italian","Italiano","Pizza italiana y pizza","dinner","360","",7);
		m8=new Menu(8,"British","Britanico","Tortitas,bacon y huevo","breakfast","300","",9);
		
		mRepository.save(m1);
		mRepository.save(m2);
		mRepository.save(m3);
		mRepository.save(m4);
		mRepository.save(m5);
		mRepository.save(m6);
		mRepository.save(m7);
		mRepository.save(m8);
	}
	
	
	
	@RequestMapping("/menu")
	public String menus(Model model, HttpServletRequest request) {
		
		List<Menu> breakfast = mRepository.findByCategory("breakfast");
		List<Menu> lunch = mRepository.findByCategory("lunch");
		List<Menu> dinner = mRepository.findByCategory("dinner");
		
		model.addAttribute("breakfast", breakfast);
		model.addAttribute("lunch", lunch);
		model.addAttribute("dinner", dinner);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		return "menu";
	}

}
