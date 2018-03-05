package com.daw.apimeals.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daw.apimeals.order.OrderRepository;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.user.UserRepository;

@Controller
public class CartController {
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private ProductRepository pRepository;
	
	@Autowired
	private OrderRepository oRepository;
	
	@RequestMapping("/cart")
	public String cart(Model model) {
		
		return "cart";
	}

}
