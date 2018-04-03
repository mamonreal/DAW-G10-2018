package com.daw.apimeals.shoppingCart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String removeProductFromCart(@PathVariable("id") Long id) {
        shoppingCartService.removeProduct(productRepository.findById(id));
        return "shoppingCart";
    }

    @GetMapping("/shoppingCart/checkout")
    public String checkout() {
        shoppingCartService.checkout();
        return "shoppingCart";
    }
	

}
