package com.daw.apimeals.menu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	
	List<Menu> findByType(String type);
	List<Menu> findByCategory(String category);
	List<Menu> findByPrice(long price);
	
}



