package com.daw.apimeals.user;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String userName;
	private String email;
	private String passwordHash;
	private String addres;
	private long telephone;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	 private List<String> roles;

}
