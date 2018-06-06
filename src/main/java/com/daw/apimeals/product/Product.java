package com.daw.apimeals.product;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.shoppingCart.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Product{
	
	interface ProductBassic{}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(ProductBassic.class)
	private long id;
	
	@JsonView(ProductBassic.class)
	private String name;
	
	@JsonView(ProductBassic.class)
	private String description;
	
	@JsonView(ProductBassic.class)
	private String type;
	
	@JsonView(ProductBassic.class)
	private String category;
	
	@JsonView(ProductBassic.class)
	private int kc;
	
	@JsonIgnore
	@Lob
	private String path;
	
	@JsonView(ProductBassic.class)
	private long price;
	
	@JsonIgnore
	@ManyToOne
	private Menu menu;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "products")
	private List<ShoppingCart> cart;

	protected Product() {}
	
	public Product (String name, String description, String type, String category, int kc, String path, long price){
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

	public int getKc() {
		return kc;
	}

	public void setKc(int kc) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

		
}
