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

@RestController
@RequestMapping("/api/ShoppingCart")
public class ShopingCartRestController {
		
		@Autowired
	    private ShoppingCartService shoppingCartService;

	    @Autowired
	    private ProductRepository productRepository;
	    
	    @RequestMapping(value= "/shoppingCart/{id}", method= RequestMethod.GET)
		public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable long id) {
			List<ProductAmount> plates = shoppingCartService.getProductsInShoppingCart();
			//return new ResponseEntity<>(plates, HttpStatus.OK);
		}
		
	    @RequestMapping(value="/shoppingCart/Product/{id}", method= RequestMethod.PUT)
	    public ResponseEntity<ShoppingCart> addProductToCart(@PathVariable("id") Long id) {
			shoppingCartService.addProduct(productRepository.findById(id));
	
			//return new ResponseEntity<>(shoppingCart,HttpStatus.OK);
	    }

	    @PostMapping("/shoppingCart/removeProduct/{id}")
	    public String removeProductFromCart(Model model, @PathVariable("id") Long id) {
	        shoppingCartService.removeProduct(productRepository.findById(id));
	        model.addAttribute("plates", shoppingCartService.getProductsInShoppingCart());
			model.addAttribute("menus", shoppingCartService.getMenuInShoppingCart());
	        return "/shoppingCart";
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

}
