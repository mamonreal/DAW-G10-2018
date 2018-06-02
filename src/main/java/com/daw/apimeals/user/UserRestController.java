package com.daw.apimeals.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.service.MainService;
import com.daw.apimeals.shoppingCart.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/user")
public class UserRestController extends MainService {	
	@Autowired 
	private UserRepository uRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	@Autowired
	private ProductRepository pRepository;
		
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public ResponseEntity<User> register(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		this.session(model, request, redirectAttributes);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = uRepository.save(user);
		userComponent.setLoggedUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		
	}


	}

}