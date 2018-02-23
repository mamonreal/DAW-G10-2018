package com.daw.apimeals.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daw.apimeals.menu.MenuRepository;

@Controller
public class OrderController {

	@Autowired 
	private OrderRepository repository;
}

