package com.daw.apimeals.shoppingCart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private ProductRepository productService;
    
    @RequestMapping("/shoppingCart")
	public String shoppingCart(Model model, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		
		
		this.session(model, request, redirectAttrs);
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
	@RequestMapping(value="/addProduct/{productId}")
    public String addProductToCart(Model model, HttpServletRequest request, RedirectAttributes redirectAttrs, @PathVariable("productId") Long productId) {
		shoppingCartService.addProduct(productService.findById(productId));
		this.session(model, request, redirectAttrs);
		List<ProductAmount> plates = shoppingCartService.getProductsInShoppingCart();
		List<MenuAmount> menus = shoppingCartService.getMenuInShoppingCart();
		model.addAttribute("plates", plates);
		model.addAttribute("menus", menus);
        return "/shoppingCart";
    }

    @GetMapping("/shoppingCart/removeProduct/{id}")
    public String removeProductFromCart(@PathVariable("productId") Long productId) {
        shoppingCartService.removeProduct(productService.findById(productId));
        return "shoppingCart";
    }

    @GetMapping("/shoppingCart/checkout")
    public String checkout() {
        shoppingCartService.checkout();
        return "shoppingCart";
    }
	

}
