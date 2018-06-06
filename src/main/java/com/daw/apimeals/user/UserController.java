package com.daw.apimeals.user;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.apimeals.product.Product;
import com.daw.apimeals.product.ProductRepository;
import com.daw.apimeals.service.EmailService;
import com.daw.apimeals.service.MainService;
import com.daw.apimeals.shoppingCart.ShoppingCart;

import freemarker.template.TemplateException;

@Controller
public class UserController extends MainService {	
	@Autowired 
	private UserRepository uRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	@Autowired
	private ProductRepository pRepository;
	
	@Autowired
	private EmailService emailService;
	
	@PostConstruct
	public void init() {
		uRepository.save(new User("miguel", "647585913", "mamonreal@gmailcom","mamonreal", "paco", "city", "address", "PC", "ROLE_USER" ));
		uRepository.save(new User("jorge", "647585912", "j.gamero@gmailcom","theyorch11", "pass", "city", "address", "PC", "ROLE_ADMIN","ROLE_USER"));
	}
	
	@RequestMapping("/user")
	public String user(Model model) {
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
			//model.addAttribute("recomended", this.recommend());
			//if(!user.getCart().isEmpty())
			//model.addAttribute("cart", user.getCart());
				//model.addAttribute("recomemended", showRecommend());
		}
		return "user";
	}
	
	public List<Product> recommend() {
		if(userComponent.isLoggedUser()) {
			User user = userComponent.getLoggedUser();
			List<ShoppingCart> userShoppingCarts = user.getCart();
			if (!userShoppingCarts.isEmpty()) {
				ShoppingCart lastShoppingCart = userShoppingCarts.get(userShoppingCarts.size() - 1);
				int kcAmount = 0;
				for (Product p: lastShoppingCart.getProducts()) {
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
	@RequestMapping("/register")
	public String register(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		this.session(model, request, redirectAttributes);
		return "register";
	}
	
	@RequestMapping("addUser")
	public String addUser(@RequestParam String name, @RequestParam String mobile,@RequestParam String email,@RequestParam String UserName,
			@RequestParam String password,@RequestParam String city,@RequestParam String address,@RequestParam String PC) {
		if (uRepository.findByEmail(email) == null) {
			User user = new User(name, mobile, email, UserName, password, city, address, PC, "ROLE_USER");
			uRepository.save(user);
			userComponent.setLoggedUser(user);
			try {
				  emailService.sendSimpleMessage(uRepository.findByEmail(email));
				  } catch (MessagingException messaginException) {
				   System.out.println(messaginException);
				  } catch (IOException IOexception) {
				   System.out.println(IOexception);
				  } catch (TemplateException templateException) {
				   System.out.println(templateException);
				  }
				  ;
				  return "/user";
	  } else {
		   //model.addAttribute("errorMessage","¡Error al crear la cuenta! El correo introducido ya está vinculado a otra cuenta.");
		      return "error2";
		      }
		
	}

	public void loadUser(Model model){
		model.addAttribute("loggedUser",userComponent.getLoggedUser());
		if(userComponent.isLoggedUser()){
			//User currentUser = uRepository.findOne(userComponent.getLoggedUser().getId());
			model.addAttribute("currentUser", userComponent.getLoggedUser());

		}
	}

}
