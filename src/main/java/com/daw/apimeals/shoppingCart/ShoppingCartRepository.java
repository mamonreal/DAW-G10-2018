package com.daw.apimeals.shoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository <ShoppingCart, Long>{
	
	ShoppingCart getCartById(long id);
	
}
