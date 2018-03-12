package com.daw.apimeals.shoppingCart;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.daw.apimeals.user.User;
import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.product.Product;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private long id;
	private long totalPrice;
	private String addres;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<Product> products;
	
	@ManyToMany(mappedBy = "cart")
	private List<Menu> menus;
	
	protected ShoppingCart() {}

	public ShoppingCart(String addres, User user) {
		this.totalPrice = 0;
		this.addres = addres;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
