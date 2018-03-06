package com.daw.apimeals.shoppingCart;

import java.util.Map;

import com.daw.apimeals.product.Product;

public interface ShoppingCartService {
	
	void addProduct(Product product);
	
	void removeProduct(Product product);
	
	Map<Product, Integer> getProductsInShoppingCart();
	
	void checkout();
	
	Long getTotal();

}
