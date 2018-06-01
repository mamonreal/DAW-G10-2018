package com.daw.apimeals.contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ContactRestController {
	@JsonView()
	@RequestMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
}