package com.daw.apimeals.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

	List<Product> findByType(String type);
//    	Page<Product> findByType(String type, Pageable page);
	List<Product> findByCategory(String category);
//		Page<Product> findByCategory(String category, Pageable page);
    Product findById(long id);
    Product findOne(long id);
    @Query("select p from Product p where p.kc < :kc")
    List<Product> findByKc(@Param("kc") String kc);
    List<Product> findByKcLessThan(int kc);
    List<Product> findAll();
}
