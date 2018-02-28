package com.daw.apimeals.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.apimeals.menu.MenuRepository;
import com.daw.apimeals.user.User;
import com.daw.apimeals.user.UserComponent;

@Controller
public class OrderController {

	@Autowired 
	private OrderRepository oRepository;
	
@RequestMapping("/order")
	public String order(Model model) {
		
		List<Order> orders = new UserComponent().getLoggedUser().getOrders();
		
		model.addAttribute("orders", orders);
		
		return "order";

	}
}

