package com.daw.apimeals.product;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
	
	@Autowired 
	private ProductRepository pRepository;
	
	@PostConstruct
	public void init() {
	Product s1,s2,s3,s4,f5,f6,se7,se8,dr9,dr10;
	s1=new Product("Nachos","starter","foreign",306,12);
	s2=new Product("Ensalada Cesar","starter","mediterranean",44,10);
	s3=new Product("Combo de entrantes","starter","foreign",370,14);
	s4=new Product("Croquetas", "starter","mediterranean",280,9);
	f5=new Product("Ensaladilla Rusa","first","vegetarian",170,11);
	pRepository.save(s1);
	pRepository.save(s2);
	pRepository.save(s3);
	pRepository.save(s4);
	pRepository.save(f5);
	}
}
