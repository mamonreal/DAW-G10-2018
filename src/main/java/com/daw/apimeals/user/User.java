package com.daw.apimeals.user;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.daw.apimeals.order.Order;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String email;
	private String passwordHash;
	private String addres;
	private long telephone;
	
	@OneToMany
	private List<Order> orders;
	
	@ElementCollection(fetch = FetchType.EAGER)
	 private List<String> roles;
	
	
}
