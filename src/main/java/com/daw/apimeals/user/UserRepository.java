package com.daw.apimeals.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends  CrudRepository<User, Long>  {
	
	User findByName(String name);
	User getById(long id);


}

