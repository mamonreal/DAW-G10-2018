package com.daw.apimeals.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.apimeals.menu.MenuRepository;

@Controller
public class OrderController {

	@Autowired 
	private OrderRepository oRepository;
	
	@RequestMapping("/orders")
	public String order(Model model) {
		return "orders";
	}
}

