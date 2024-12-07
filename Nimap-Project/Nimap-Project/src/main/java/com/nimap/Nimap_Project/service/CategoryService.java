package com.nimap.Nimap_Project.service;

import com.nimap.Nimap_Project.entity.Category;
import com.nimap.Nimap_Project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategoryService(Category category_data) {
        System.out.println("hello11");
        categoryRepository.save(category_data);
        System.out.println("hello12");
    }

    public List<Category> getAllCategoriesService(Integer page) {
        return (List<Category>) categoryRepository.findAll();
    }

    public Object categoryByIdService(String id) {
        return categoryRepository.findById(id);
    }

    public Object updateCategoryByIdService(String id,Category data) {
        Optional<Category> category=categoryRepository.findById(id);
        if(category.isPresent()){
            Category category1=category.get();
            category1.setCategory_name(data.getCategory_name());
            category1.setUpdated_at(data.getUpdated_at());
            category1.setCreated_at(data.getCreated_at());
            category1.setModified_by(data.getModified_by());
            categoryRepository.save(category1);
            return "Updated Successfully";
        }
        else{
            return "NOT FOUND";
        }
    }


    public Object deleteByIdService(String id) {
        Optional<Category> category=categoryRepository.findById(id);
        if(category.isPresent()){
            categoryRepository.deleteById(id);
            return "Deleted Successfully";
        }
        else{
            return "NOT FOUND";
        }
    }
}
