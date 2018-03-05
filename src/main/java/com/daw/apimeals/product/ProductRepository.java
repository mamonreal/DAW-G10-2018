package com.daw.apimeals.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

    List<Product> findByType(String type);
    Product findById(long id);
}
