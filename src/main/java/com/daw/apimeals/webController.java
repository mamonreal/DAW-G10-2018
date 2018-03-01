package com.daw.apimeals;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class webController {
	
	@RequestMapping("/")
		public String index() {
			return "index";
	}
	
}





