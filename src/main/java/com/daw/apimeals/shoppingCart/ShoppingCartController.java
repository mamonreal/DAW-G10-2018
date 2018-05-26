package com.daw.apimeals.shoppingCart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.service.MainService;

@Controller
public class ShoppingCartController extends MainService{
	
	@Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductRepository productRepository;
    
    @RequestMapping("/shoppingCart")
	public String shoppingCart(Model model) {
		List<ProductAmount> plates = shoppingCartService.getProductsInShoppingCart();
		List<MenuAmount> menus = shoppingCartService.getMenuInShoppingCart();
		model.addAttribute("plates", plates);
		model.addAttribute("menus", menus);
		return "shoppingCart";
	}
	
    @PostMapping(value="/shoppingCart/addProduct/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
		shoppingCartService.addProduct(productRepository.findById(id));
		model.addAttribute("plates", shoppingCartService.getProductsInShoppingCart());
		model.addAttribute("menus", shoppingCartService.getMenuInShoppingCart());
		return "shoppingCart";
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
