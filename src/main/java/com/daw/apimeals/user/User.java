package com.daw.apimeals.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.daw.apimeals.shoppingCart.ShoppingCart;

//import com.daw.apimeals.order.Order;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String email;
	private String passwordHash;
	private String address;
	private long telephone;
	private String UserName;
	private String city;
	private String PC;
	private String kc;
	
	
	@OneToMany(mappedBy = "user")
	private List<ShoppingCart> cart;
	
	@ElementCollection(fetch = FetchType.EAGER)
	 private List<String> roles;
	
	
	public User() {}

	public User(String name, String email, String passwordHash, String address, long telephone, List<String> roles, List<ShoppingCart> cart) {
		super();
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.address = address;
		this.telephone = telephone;
//		this.orders = orders;
		this.roles = roles;
		this.kc = "";
		this.cart = null;
	}
	
	public User(String name, String mobile, String email, String UserName, String password, String city, String address, String PC, String... roles) {
		this.name=name;
		this.telephone=(long)Long.parseLong(mobile);
		this.email=email;
		this.UserName=UserName;
		this.passwordHash= new BCryptPasswordEncoder().encode(password);
		this.city=city;
		this.address=address;
		this.PC=PC;		
		this.roles = new ArrayList<>(Arrays.asList(roles));
		this.kc = "";
		this.cart = new ArrayList<ShoppingCart>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getAddress() {
		return address;
	}

	public void setAddres(String address) {
		this.address = address;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPC() {
		return PC;
	}

	public void setPC(String pC) {
		PC = pC;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ShoppingCart> getCart() {
		return cart;
	}

	public void setCart(List<ShoppingCart> cart) {
		this.cart = cart;
	}
	
	public void addShoppingCart(ShoppingCart shoppingCart) {
		cart.add(shoppingCart);
	}
	
	public void initializeCart() {
		this.cart = new ArrayList<ShoppingCart>();
	}
	
}
