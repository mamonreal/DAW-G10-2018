package com.daw.apimeals.product;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daw.apimeals.menu.Menu;

import java.util.List;

@Controller
public class ProductController {
	
	@Autowired 
	private ProductRepository pRepository;
	
	@PostConstruct
	public void init() {
	Product s1,s2,s3,s4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,se7,se8,dr9,dr10;
	s1=new Product("Nachos","Deliciosos nachos al estilo tex-mex","entree","foreign",306,"",12);
	s2=new Product("Ensalada Cesar","Ensalada de luechuga con pollo y salsa cesar","entree","mediterranean",44,"",10);
	s3=new Product("Combo de entrantess","Un delicioso entrante con 6 aros de cebolla, nachos texmex, fingers de queso, alitas de pollo, croquetas","entree","foreign",370,"",14);
	s4=new Product("Croquetas","Croquetas de jamón, Mozzarella y pan rallado al estilo japonés. Acompañadas de tomate seco, cebolla crujiente, alcaparras fritas y salsas BBQ Ranch y tomate.", "entree","mediterranean",280,"",9);
	f5=new Product("Ensaladilla Rusa","Deliciosa ensaladilla rusa con aceitunas, atún, zanahoria, patata, guisantes y huevo.","first","vegetarian",170,"",11);
	f6=new Product("Pasta con salsa parmesano","Macarrones acompañados de una espectacular salsa parmesano al estilo italiano","first","mediterranean",120,"",10);
	f7=new Product("Arroz caldoso","Delicioso arroz elaborado con mucho cuidado para que disfrutes de un plato tradicional","first","mediterranean",69,"",13);
	f8=new Product("Verduras a la plancha","Verduras con aceite de girasol, aceita de oliva y un aroma natural de humo","first","vegetarian",98,"",9);
	f9=new Product("Medalones de pavo","Jugosos medallones de pavo a la plancha acompañados de una deliciosa salsa casera y patatas fritas","second","mediterranean",229,"",14);
	f10=new Product("Albóndigas con tomate","Albóndigas como las hacía tu abuela, tal caul, disfrútalas","second","mediterranean",163,"",12);
	f11=new Product("Costillas asadas","Jugosas costillas asadas complementadas con una deliciosa salsa BBQ que te hará chuparte los dedos","second","foreign",982,"",17);
	f12=new Product("Lomo de atún con pisto","Nuestro pisto jugoso proporciona al atún un sabor único e inigualable","second","mediterranean",135,"",15);
	f13=new Product("Brownie de chocolate","Para los amantes del chocolate, déjate seducir por este delicioso y dulce postre","Dessert","foreign",377,"",5);
	f14=new Product("Macedonia","Fresa, kiwi, naranja y plátano, nada más","Dessert","mediterranean",50,"",4);
	f15=new Product("Nestea","33cl","drinks","foreign",106,"",2);
	f16=new Product("Agua mineral","1L","drinks","mediterranean",0,"",2);
	
	pRepository.save(s1);
	pRepository.save(s2);
	pRepository.save(s3);
	pRepository.save(s4);
	pRepository.save(f5);
	pRepository.save(f6);
	pRepository.save(f7);
	pRepository.save(f8);
	pRepository.save(f9);
	pRepository.save(f10);
	pRepository.save(f11);
	pRepository.save(f12);
	pRepository.save(f13);
	pRepository.save(f14);
	pRepository.save(f15);
	pRepository.save(f16);
	}

    @RequestMapping("/plates")
    public String plates(Model model,HttpServletRequest request) {

	    List<Product> entrees = pRepository.findByType("entree");
	    List<Product> first = pRepository.findByType("first");
	    List<Product> second = pRepository.findByType("Second");
	    List<Product> desserts = pRepository.findByType("Dessert");
	    List<Product> drinks = pRepository.findByType("drinks");
	   
	    model.addAttribute("entrees", entrees);
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("desserts", desserts);
        model.addAttribute("drinks", drinks);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));

	       
	    return "plates";
    }

}
