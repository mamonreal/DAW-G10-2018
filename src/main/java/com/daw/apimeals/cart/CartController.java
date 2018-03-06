package com.daw.apimeals.cart;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.daw.apimeals.order.OrderRepository;
import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.service.MainService;
import com.daw.apimeals.user.User;
import com.daw.apimeals.user.UserRepository;

@Controller
public class CartController extends MainService{
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private ProductRepository pRepository;
	
//	@Autowired
//	private OrderRepository oRepository;
//	
//	@RequestMapping("/shoppingCart")
//	public String cart(Model model,HttpServletRequest request, RedirectAttributes redirectAttrs) {
//		this.session(model, request, redirectAttrs);
//		return "shoppingCart";
//	}
//	
//	@RequestMapping("/shoppingCart/{id}")
//	public String addProduct(@PathVariable long id) {
//		Cart cart = new Cart();	
//		Product product = pRepository.findById(id);
//		List<Product> products = cart.getProductos();
//		products.add(product);
//		cart.setProductos(products);
//		return "shoppingCart";
//	}

}
