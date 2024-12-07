package com.nimap.Nimap_Project.repository;

import com.nimap.Nimap_Project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
