package com.daw.apimeals.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.daw.apimeals.cart.Cart;
import com.daw.apimeals.menu.Menu;

@Entity
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String description;
	private String type;
	private String category;
	private Integer kc;
	private String path;
	private long price;
	
	@ManyToOne
	private Menu menu;
	
	@ManyToOne
	private Cart cart;

	protected Product() {}
	
	public Product (String name, String description, String type, String category, Integer kc, String path, long price){
		this.name=name;
		this.description=description;
		this.type=type;
		this.category=category;
		this.kc=kc;
		this.path=path;
		this.price=price;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getKc() {
		return kc;
	}

	public void setKc(Integer kc) {
		this.kc = kc;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
}
