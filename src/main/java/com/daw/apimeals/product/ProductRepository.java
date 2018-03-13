package com.daw.apimeals.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

	List<Product> findByType(String type);
//    Page<Product> findByType(String type, Pageable page);
    Product findById(long id);
    Product findOne(long id);
}
