package com.daw.apimeals.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OwnErrorController implements ErrorController{

	@RequestMapping("/error")
	public String error(Model model, HttpServletRequest request) {
		return "/error";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
