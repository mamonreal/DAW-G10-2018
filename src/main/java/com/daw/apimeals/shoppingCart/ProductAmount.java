package com.daw.apimeals.shoppingCart;

import com.daw.apimeals.product.Product;

public class ProductAmount {
	private Product product;
	private Integer amount;
	
	public ProductAmount() {}

	public ProductAmount(Product product, Integer amount) {
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
