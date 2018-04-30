package com.daw.apimeals.shoppingCart;

import java.util.List;
import com.daw.apimeals.product.Product;
import com.daw.apimeals.user.User;

public interface ShoppingCartService {
	
	void addProduct(Product product);
	
	void removeProduct(Product product);
	
	List<ProductAmount> getProductsInShoppingCart();
	
	List<MenuAmount> getMenuInShoppingCart();
	
	void checkout(ShoppingCart shoppingCart);
	
	Long getTotal();

}
