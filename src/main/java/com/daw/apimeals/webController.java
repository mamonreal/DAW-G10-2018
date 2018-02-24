package com.daw.apimeals;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webController {
	
	@RequestMapping("/")
		public String index() {
			return "index";
	}
	@RequestMapping("/menu")
	public String menu () {
		return "menu";
}

	@RequestMapping("/orders")
	public String orders() {
		return "orders";
}




}
