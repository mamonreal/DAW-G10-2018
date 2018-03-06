package com.daw.apimeals.shoppingCart;

import java.util.List;
import com.daw.apimeals.product.Product;

public interface ShoppingCartService {
	
	void addProduct(Product product);
	
	void removeProduct(Product product);
	
	List<ProductAmount> getProductsInShoppingCart();
	
	List<MenuAmount> getMenuInShoppingCart();
	
	void checkout();
	
	Long getTotal();

}
