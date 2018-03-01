package com.daw.apimeals.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.daw.apimeals.user.User;
import com.daw.apimeals.user.UserRepository;

public class DataBaseUsersLoaders {
	@Autowired
	private UserRepository userRepository;
	@PostConstruct
	private void initDatabase() {

	//userRepository.save(new User("user",9123,"emailu","username","pass","Madrid","address","27111","ROLE_USER"));
	//userRepository.save(new User("admin","adminpass","ROLE_USER","ROLE_ADMIN", 0, null, null));

	}
}
