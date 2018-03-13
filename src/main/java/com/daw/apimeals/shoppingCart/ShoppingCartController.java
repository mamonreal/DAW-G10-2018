package com.daw.apimeals.shoppingCart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		
//		this.session(model, request, redirectAttrs);
		List<ProductAmount> plates = shoppingCartService.getProductsInShoppingCart();
		List<MenuAmount> menus = shoppingCartService.getMenuInShoppingCart();
		model.addAttribute("plates", plates);
		model.addAttribute("menus", menus);
		return "shoppingCart";
	}
	
//	@GetMapping("/shoppingCart")
//    public ModelAndView shoppingCart() {
//        ModelAndView modelAndView = new ModelAndView("shoppingCart");
//        modelAndView.addObject("products", shoppingCartService.getProductsInShoppingCart());
//        modelAndView.addObject("total", shoppingCartService.getTotal().toString());
//        return modelAndView;
//    }
//
	@PostMapping(value="/shoppingCart/addProduct/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
		shoppingCartService.addProduct(productRepository.findById(id));
		model.addAttribute("plates", shoppingCartService.getProductsInShoppingCart());
		model.addAttribute("menus", shoppingCartService.getMenuInShoppingCart());
		return "shoppingCart";
    }

    @GetMapping("/shoppingCart/removeProduct/{id}")
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
