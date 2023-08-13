package com.electronic.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
