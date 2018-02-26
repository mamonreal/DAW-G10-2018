package com.daw.apimeals.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@Autowired 
	private MenuRepository mRepository;
	
	@RequestMapping("/menu")
	public String menus(Model model) {
		
		List<Menu> breakfast = mRepository.findBycategory("breakfast");
		List<Menu> lunch = mRepository.findBycategory("lunch");
		List<Menu> dinner = mRepository.findBycategory("dinner");
		
		model.addAttribute("breakfast", breakfast);
		model.addAttribute("lunch", lunch);
		model.addAttribute("dinner", dinner);
		
		return "menu";
	}
}
