
package com.daw.apimeals.menu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.daw.apimeals.product.Product;
import com.daw.apimeals.shoppingCart.ShoppingCart;


@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String type;
	private String description;
	private String category;
	private String kc;
	private String path;
	private long price;
	
	@OneToMany(mappedBy="menu")
	private List<Product> products;
	
	@ManyToMany
	private List<ShoppingCart> cart;
	
	protected Menu() {}
	
	public Menu (long id, String name, String type, String description, String category, String kc, String path, long price){
		this.id=id;
		this.name=name;
		this.type=type;
		this.description=description;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
}

