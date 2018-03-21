package com.daw.apimeals.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.apimeals.menu.MenuRepository;
//import com.daw.apimeals.order.OrderRepository;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.user.User;
import com.daw.apimeals.user.UserRepository;

public class MainService {
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private ProductRepository pRepository;

	@Autowired
	private MenuRepository mRepository;
	
	public void session (Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")){
			User loggedUser = uRepository.findByName(request.getUserPrincipal().getName());
			if(request.isUserInRole("ROLE_USER")) {
				model.addAttribute("user", true);
			}
			if(request.isUserInRole("ROLE_ADMIN")) {
				model.addAttribute("admin",true);
			}
		}
	}
}
