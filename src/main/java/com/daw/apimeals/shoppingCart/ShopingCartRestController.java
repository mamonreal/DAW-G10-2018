package com.daw.apimeals.shoppingCart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.service.MainService;
import com.daw.apimeals.user.User;
import com.daw.apimeals.user.UserRepository;

@RestController
@RequestMapping("/api/ShoppingCart")
public class ShopingCartRestController {
		
		@Autowired
	    private ShoppingCartService shoppingCartService;

	    @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private ShoppingCartRepository cartRepository;
	    
	    @RequestMapping(value= "/shoppingCart/{id}", method= RequestMethod.GET)
		public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable long id) {
	    	ShoppingCart newCart = cartRepository.getCartById(id);
			return new ResponseEntity<>(newCart, HttpStatus.OK);
		}
		
	    @RequestMapping(value="/shoppingCart/Product/{id}", method= RequestMethod.PUT)
	    public ResponseEntity<Boolean> addProductToCart(@PathVariable("id") long id) {
	    	Product product = productRepository.findById(id);
	    	if (product!=null) {
	    		shoppingCartService.addProduct(product);
	    	    return new ResponseEntity<>(true,HttpStatus.OK);
	    	}
	    	return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value="/shoppingCart/removeProduct/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Boolean> removeProductFromCart(@PathVariable("id") long id) {
	    	Product product = productRepository.findById(id);
	    	if (product!=null) {
	    		shoppingCartService.removeProduct(productRepository.findById(id));
	    		return new ResponseEntity<>(true,HttpStatus.OK);
	    	}
	        return new ResponseEntity<>(true,HttpStatus.NOT_FOUND);
	    }

	    @PostMapping("/shoppingCart/checkout/{address}")
	    public String checkout(@PathVariable("address") String address) {
	    	List<Product> p = new ArrayList<>();
	    	List<Menu> m = new ArrayList<>();
	    	
	    	for (ProductAmount pa: shoppingCartService.getProductsInShoppingCart()) {
	    		for (int i = 0; i < pa.getAmount(); i++) {
	    			p.add(pa.getProduct());
	    		}
	    	}
	    	for (MenuAmount ma: shoppingCartService.getMenuInShoppingCart()) {
	    		for (int i = 0; i < ma.getAmount(); i++) {
	    			m.add(ma.getProduct());
	    		}
	    	}
	    	
	    	shoppingCartService.checkout(new ShoppingCart(address, p, m));
	        return "/shoppingCart";
	    }
		

}