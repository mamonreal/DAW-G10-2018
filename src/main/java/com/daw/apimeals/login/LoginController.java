package com.daw.apimeals.login;

import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.apimeals.user.User;
import com.daw.apimeals.user.UserComponent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class LoginController {
	
	@RequestMapping(value={"/login"})
	public String loginController(Model model, HttpServletRequest request){
		model.addAttribute("loginerror",false);
		return "login";
	}
	
	@RequestMapping(value={"/loginerror"})
	public String loginerrorController(Model model, HttpServletRequest request){
		model.addAttribute("loginerror",true);
		return "login";
	}
    @RequestMapping("/afterLog")
    public String home(Model model, HttpServletRequest request) {
    	
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	
    	return "afterLog";
    }
    @RequestMapping("/admin")
    public String admin() {
    	return "admin";
    }
}

