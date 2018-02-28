package com.daw.apimeals.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Cart findBycartId(String cartId);
	Cart getCartByCartId(String cartId);
	
}
