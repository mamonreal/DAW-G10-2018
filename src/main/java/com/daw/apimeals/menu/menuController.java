package com.daw.apimeals.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	@Autowired 
	private MenuRepository repository;
	
	
	

}
