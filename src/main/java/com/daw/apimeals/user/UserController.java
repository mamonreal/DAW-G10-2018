package com.daw.apimeals.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daw.apimeals.menu.MenuRepository;

@Controller
public class UserController {
	
	@Autowired 
	private UserRepository uRepository;

}
