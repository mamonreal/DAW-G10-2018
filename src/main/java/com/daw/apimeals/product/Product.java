package com.daw.apimeals.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.daw.apimeals.menu.Menu;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String type;
	private String category;
	private String kc;
	private long price;
	
	@ManyToOne
	private Menu menu;

protected Product() {}
	
	public Product (long id, String name, String type, String category, String kc, long price){
		this.id=id;
		this.name=name;
		this.type=type;
		this.category=category;
		this.kc=kc;
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

	public String getKc() {
		return kc;
	}

	public void setKc(String kc) {
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
	
}
