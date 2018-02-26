package com.daw.apimeals.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

	@RequestMapping("/com/daw/apimeals/error")
	public String error(Model model) {
		return "com/daw/apimeals/error";
	}
}
