package com.daw.apimeals.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.service.MainService;
import com.daw.apimeals.shoppingCart.ShoppingCart;

@RestController
@RequestMapping("/api/user")
public class UserRestController extends MainService {	
	@Autowired 
	private UserRepository uRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	@Autowired
	private ProductRepository pRepository;
	
	@PostConstruct
	public void init() {
		uRepository.save(new User("miguel", "647585913", "mamonreal@gmailcom","mamonreal", "paco", "city", "address", "PC", "ROLE_USER" ));
		uRepository.save(new User("jorge", "647585912", "j.gamero@gmailcom","theyorch11", "pass", "city", "address", "PC", "ROLE_ADMIN","ROLE_USER"));
	}
	
	@RequestMapping("/user")
	public ResponseEntity<User> profile (Model model) {
        Boolean b = userComponent.isLoggedUser();
        model.addAttribute("logged", b);
		if (b) {
			User user = userComponent.getLoggedUser();
			user.initializeCart();
			user = uRepository.getById(user.getId());
			
			model.addAttribute("name", user.getName());
			model.addAttribute("username", user.getUserName());
			model.addAttribute("phone", user.getTelephone());
			model.addAttribute("address", user.getAddress());
			model.addAttribute("city", user.getCity());
			model.addAttribute("cp", user.getPC());
			model.addAttribute("role", user.getRoles());
			model.addAttribute("cart", user.getCart());
			model.addAttribute("recomended", this.recommend());
			//if(!user.getCart().isEmpty())
			//model.addAttribute("cart", user.getCart());
				//model.addAttribute("recomemended", showRecommend());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	public List<Product> recommend() {
		if(userComponent.isLoggedUser()) {
			User user = userComponent.getLoggedUser();
			List<ShoppingCart> userShoppingCarts = user.getCart();
			if (!userShoppingCarts.isEmpty()) {
				ShoppingCart lastShppingCart = userShoppingCarts.get(userShoppingCarts.size() - 1);
				int kcAmount = 0;
				for (Product p: lastShppingCart.getProducts()) {
					kcAmount += p.getKc();
				}
				return pRepository.findByKcLessThan(kcAmount);
			}
		}
		return null;
	}
	
	/*
	public int kcCart() {
		User user = userComponent.getLoggedUser();
		int kCcarrito=0;
		ShoppingCart last;
		List<ShoppingCart> lastCart= new ArrayList<ShoppingCart>();
		lastCart=user.getCart();
		int n=lastCart.size();
		last=lastCart.get(n-1);
		for(int i=0; i<last.getProducts().size(); i++) {
			kCcarrito+=Integer.parseInt(last.getProducts().get(i).getKc());
		}
		return kCcarrito;
	}
	
	public List<Product> showRecommend() {
		String kcRecommended=String.valueOf(kcCart());
		String category=null;
		if(kcCart()>=600)
			category="light";
		if(kcCart()>250 && kcCart()<600)
			category="mediterranean";
		if(kcCart()<=250)
			category="fast";
		List<Product>productsRecommended=pRepository.findByCategory(category);
		return productsRecommended;
		
		}
	
	*/
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public ResponseEntity<User> register(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		this.session(model, request, redirectAttributes);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = uRepository.save(user);
		userComponent.setLoggedUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		
	}

	public void loadUser(Model model){
		model.addAttribute("loggedUser",userComponent.getLoggedUser());
		if(userComponent.isLoggedUser()){
			//User currentUser = uRepository.findOne(userComponent.getLoggedUser().getId());
			model.addAttribute("currentUser", userComponent.getLoggedUser());

		}
	}

}