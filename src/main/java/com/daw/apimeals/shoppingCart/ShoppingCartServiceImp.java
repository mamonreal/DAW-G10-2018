 package com.daw.apimeals.shoppingCart;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.user.User;
import com.daw.apimeals.user.UserComponent;
import com.daw.apimeals.user.UserRepository;
import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.product.Product;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImp implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	@Autowired
	private UserRepository userRepository;
	
	private Map<Product, Integer> products = new HashMap<>();
	private Map<Menu, Integer> menus = new HashMap<>();

	@Override
	public void addProduct(Product product) {
		if (products.containsKey(product)) {
			products.replace(product, products.get(product)+1);			
		} else {
			products.put(product, 1);
		}		
	}

	@Override
	public void removeProduct(Product product) {
		if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
		
	}

	@Override
	public List<ProductAmount> getProductsInShoppingCart() {
		List<Product> prod = new ArrayList<> (products.keySet());
		List<Integer> amount = new ArrayList<> (products.values());
		List<ProductAmount> pa = new LinkedList<>();
		if (prod.size() == amount.size()) {
			for (int i = 0; i < prod.size(); i++) {
				pa.add(new ProductAmount(prod.get(i), amount.get(i)));
			}
		}
		
		return pa;
	}
	
	@Override
	public List<MenuAmount> getMenuInShoppingCart() {
		List<Menu> menu = new ArrayList<>(menus.keySet());
		List<Integer> amount = new ArrayList<>(menus.values());
		List<MenuAmount> ma = new LinkedList<>();
		if (menu.size() == amount.size()) {
			for (int i = 0; i < menu.size(); i++) {
				ma.add(new MenuAmount(menu.get(i), amount.get(i)));
			}
		}
		return ma;
	}

	@Override
	public Long getTotal() {
		Long total = new Long(0);
		for (Map.Entry<Product, Integer> entry: products.entrySet()) {
			total += (entry.getKey().getPrice() * entry.getValue());
		}
		return total;
	}

	@Override
	public void checkout(ShoppingCart shoppingCart) {
		
		if (userComponent.isLoggedUser()) {
			User user = userRepository.findByName(userComponent.getLoggedUser().getName());
			
			shoppingCart.setUser(user);
			shoppingCart.setAddress(user.getAddress());
			user.addShoppingCart(shoppingCart);
		}
		shoppingCartRepository.save(shoppingCart);
		shoppingCartRepository.flush();
		
		products = new HashMap<>();
		menus = new HashMap<>();
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	public Map<Menu, Integer> getMenus() {
		return menus;
	}

	public void setMenus(Map<Menu, Integer> menus) {
		this.menus = menus;
	}
	
	
	
}
