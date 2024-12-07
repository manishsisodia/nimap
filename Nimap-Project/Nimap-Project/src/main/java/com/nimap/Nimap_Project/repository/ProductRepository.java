package com.nimap.Nimap_Project.repository;

import com.nimap.Nimap_Project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
