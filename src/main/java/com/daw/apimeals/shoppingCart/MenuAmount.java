package com.daw.apimeals.shoppingCart;

import com.daw.apimeals.menu.Menu;

public class MenuAmount {
	private Menu product;
	private Integer amount;
	
	public MenuAmount() {}

	public MenuAmount(Menu menu, Integer amount) {
		this.product = menu;
		this.amount = amount;
	}

	public Menu getProduct() {
		return product;
	}

	public void setProduct(Menu product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}

