package com.daw.apimeals.menu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	
	List<Menu> findBytype(String type);
	List<Menu> findBycategory(String category);
	List<Menu> findByprice(long price);
	
	

}
