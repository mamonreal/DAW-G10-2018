package com.daw.apimeals.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.daw.apimeals.service.MainService;

@RestController
@RequestMapping(value = "/api")
public class UserRestController extends MainService {	
	@Autowired 
	private UserRepository uRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable long id) {
		User newUser = uRepository.getById(id);
		userComponent.setLoggedUser(newUser);
		if (newUser!=null)
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		return new ResponseEntity<>(newUser,HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> removeUser(@PathVariable long id) {
		uRepository.delete(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addUser(@RequestBody User user) {
		uRepository.save(user);
		userComponent.setLoggedUser(user);
		return new ResponseEntity<>(true, HttpStatus.CREATED);
		
	}


}