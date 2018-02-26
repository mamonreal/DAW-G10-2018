package com.daw.apimeals.login;

import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
