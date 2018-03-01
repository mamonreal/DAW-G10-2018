package com.daw.apimeals.user;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.apimeals.service.MainService;

@Controller
public class UserController extends MainService {
	
	@Autowired 
	private UserRepository uRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	@PostConstruct
	public void init() {
		uRepository.save(new User("jorge", "6475859", "j.gamero@gmailcom","theyorch11", "pass", "city", "address", "PC", "ROLE_USER" ));
	}
	
	@RequestMapping("/user")
	public String user(Model model) {
        Boolean b = userComponent.isLoggedUser();
        model.addAttribute("logged", b);
        
		if (b) {
			User user = userComponent.getLoggedUser();
			
			model.addAttribute("name", user.getName());
			model.addAttribute("username", user.getUserName());
			model.addAttribute("phone", user.getTelephone());
			model.addAttribute("address", user.getAddress());
			model.addAttribute("city", user.getCity());
			model.addAttribute("cp", user.getPC());
		}
		
        return "user";
	}
	
	@RequestMapping("/register")
	public String register(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		this.session(model, request, redirectAttributes);
		return "register";
	}
	
	@RequestMapping("addUser")
	public String addUser(@RequestParam String name, @RequestParam String mobile,@RequestParam String email,@RequestParam String UserName,
			@RequestParam String password,@RequestParam String city,@RequestParam String address,@RequestParam String PC) {
		User user = new User(name, mobile, email, UserName, password, city, address, PC, "ROLE_USER");
		uRepository.save(user);
		userComponent.setLoggedUser(user);
		return "/user";
		
	}
	
	
	public void loadUser(Model model){
		model.addAttribute("loggedUser",userComponent.getLoggedUser());
		if(userComponent.isLoggedUser()){
			User currentUser = uRepository.findOne(userComponent.getLoggedUser().getId());
			model.addAttribute("currentUser", userComponent.getLoggedUser());
		}
		
		

		
	}

}
