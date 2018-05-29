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
	private String address;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<Product> products;
	
	@ManyToMany(mappedBy = "cart")
	private List<Menu> menus;
	
	protected ShoppingCart() {}

	public ShoppingCart(String address) {
		this.totalPrice = 0;
		this.address = address;
	}

	public ShoppingCart(String address, List<Product> products, List<Menu> menus) {
		super();
		this.address = address;
		this.products = products;
		this.menus = menus;
		
		this.totalPrice = 0;
		for (Product p : products) {
			totalPrice += p.getPrice();
		}
		for (Menu m: menus) {
			totalPrice += m.getPrice();
		}
	}
	public int cartKC(List<Product> products) {
		int kcTotal = 0;
		for(Product p: products)
			kcTotal += p.getKc();
		return kcTotal;
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
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
