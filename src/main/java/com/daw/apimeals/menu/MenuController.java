package com.daw.apimeals.menu;

import java.util.List;

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

@Controller
public class MenuController {
	
	@Autowired 
	private MenuRepository mRepository;
	
	
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
