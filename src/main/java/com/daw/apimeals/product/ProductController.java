package com.daw.apimeals.product;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.apimeals.menu.Menu;
import com.daw.apimeals.user.UserComponent;
import com.daw.apimeals.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
	
	@Autowired 
	private ProductRepository pRepository;
	
	@Autowired
	UserComponent userComponent;
	
	@PostConstruct
	public void init() {
		Product s1,s2,s3,s4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,se1,se2,se3,d1,d2,dr1,dr2;
		// s=starter, f=first course, se=second course, d=dessert, dr=drink;
		s1=new Product("Nachos","Deliciosos nachos al estilo tex-mex","entree","fast",306,"",12);
		s2=new Product("Ensalada Cesar","Ensalada de lechuga con pollo y salsa cesar","entree","light",44,"",10);
		s3=new Product("Combo de entrantess","Un delicioso entrante con 6 aros de cebolla, nachos texmex, fingers de queso, alitas de pollo, croquetas","entree","fast",370,"",14);
		s4=new Product("Croquetas","Croquetas de jamón, Mozzarella y pan rallado al estilo japonés. Acompañadas de tomate seco, cebolla crujiente, alcaparras fritas y salsas BBQ Ranch y tomate.", "entree","mediterranean",280,"",9);
		f5=new Product("Ensaladilla Rusa","Deliciosa ensaladilla rusa con aceitunas, atún, zanahoria, patata, guisantes y huevo.","first","light",120,"",11);
		f6=new Product("Pasta con salsa parmesano","Macarrones acompañados de una espectacular salsa parmesano al estilo italiano","first","mediterranean",170,"",10);
		f7=new Product("Arroz caldoso","Delicioso arroz elaborado con mucho cuidado para que disfrutes de un plato tradicional","first","light",69,"",13);
		f8=new Product("Verduras a la plancha","Verduras con aceite de girasol, aceita de oliva y un aroma natural de humo","first","light",98,"",9);
		f9=new Product("Medallones de pavo","Jugosos medallones de pavo a la plancha acompañados de una deliciosa salsa casera y patatas fritas","second","mediterranean",229,"",14);
		se1=new Product("Albóndigas con tomate","Albóndigas como las hacía tu abuela, tal caul, disfrútalas","second","mediterranean",163,"",12);
		se2=new Product("Costillas asadas","Jugosas costillas asadas complementadas con una deliciosa salsa BBQ que te hará chuparte los dedos","second","fast",982,"",17);
		se3=new Product("Lomo de atún con pisto","Nuestro pisto jugoso proporciona al atún un sabor único e inigualable","second","light",135,"",15);
		d1=new Product("Brownie de chocolate","Para los amantes del chocolate, déjate seducir por este delicioso y dulce postre","Dessert","fast",377,"",5);
		d2=new Product("Macedonia","Fresa, kiwi, naranja y plátano, nada más","Dessert","light",50,"",4);
		dr1=new Product("Nestea","33cl","drinks","light",106,"",2);
		dr2=new Product("Agua mineral","1L","drinks","light",0,"",2);

		pRepository.save(s1);
		pRepository.save(s2);
		pRepository.save(s3);
		pRepository.save(s4);
		pRepository.save(f5);
		pRepository.save(f6);
		pRepository.save(f7);
		pRepository.save(f8);
		pRepository.save(f9);
		pRepository.save(se1);
		pRepository.save(se2);
		pRepository.save(se3);
		pRepository.save(d1);
		pRepository.save(d2);
		pRepository.save(dr1);
		pRepository.save(dr2);
		for (int i = 0; i<15; i++) {
			pRepository.save(new Product("Entrante " + i,"","entree","",10,"",10));
		}
		for (int i = 0; i<15; i++) {
			pRepository.save(new Product("Principal " + i,"","first","",10,"",10));
		}
		for (int i = 0; i<15; i++) {
			pRepository.save(new Product("Segundo " + i,"","second","",10,"",10));
		}
		for (int i = 0; i<15; i++) {
			pRepository.save(new Product("Postre " + i,"","Dessert","",10,"",10));
		}
		for (int i = 0; i<15; i++) {
			pRepository.save(new Product("Bebida" + i,"","drink","",10,"",10));
		}
	}

    @RequestMapping("/products")
    public String plates(Model model,HttpServletRequest request) {
    	List<Product> products = pRepository.findAll().subList(0, Math.min(pRepository.findAll().size(),10));
    	List<Product> entrees = pRepository.findByType("entree").subList(0, Math.min(pRepository.findAll().size(),10));
	    List<Product> first = pRepository.findByType("first").subList(0, Math.min(pRepository.findAll().size(),10));
	    List<Product> second = pRepository.findByType("second").subList(0, Math.min(pRepository.findAll().size(),10));
	    List<Product> desserts = pRepository.findByType("Dessert").subList(0, Math.min(pRepository.findAll().size(),10));
	    List<Product> drinks = pRepository.findByType("drink").subList(0, Math.min(pRepository.findAll().size(),10));
	   
	    model.addAttribute("entrees", entrees);
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("desserts", desserts);
        model.addAttribute("drinks", drinks);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));

	    return "plates";
    }
    
    @RequestMapping(value={"showMore/{page}"})
	public String indexScrollPosts(Model model, @PathVariable int page){
    	List<Product> showMore = null;
    	List<Product> products = new ArrayList<>();
    	String t = null;
    	String p = null;
    	//if(type == 1) {
    		products = pRepository.findByType("entree");
    		t = "entrees";
		//}
		if (page*10 < products.size()){
			if ((page+1)*10 <= products.size()){
				showMore = products.subList(page*10, (page+1)*10);
			} else {
				showMore = products.subList(page*10,products.size());
			}
		}
        model.addAttribute(t, showMore);
//		model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ADMIN"));
		return "showMore";
	}
    
    

    @RequestMapping("/addProduct")
    public String addProduct(Model model, @RequestParam String name,@RequestParam String description, @RequestParam String category, @RequestParam String type, @RequestParam String kc, @RequestParam String price ) {
    	Product product= new Product(name,description,type, category,Integer.parseInt(kc),"",Long.parseLong(price));
    	pRepository.save(product);

    	return "/products";
    }
    
    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(Model model,@PathVariable long id ) {
    	Product product = pRepository.findById(id);
    	pRepository.delete(product);
    	return "/products";
    }
    	    
}
    
