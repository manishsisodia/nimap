package com.nimap.Nimap_Project.controller;

import com.nimap.Nimap_Project.entity.Category;
import com.nimap.Nimap_Project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategoryController(@RequestBody Category category_data){
        System.out.println("data-------"+category_data.toString());
        try{

            categoryService.createCategoryService(category_data);
            return new ResponseEntity<>(category_data, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCategoriesController(@RequestParam("page") Integer page){
        return new ResponseEntity<>(categoryService.getAllCategoriesService(page),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> categoryByIdController(@PathVariable String id){
        try{
            return new ResponseEntity<>(categoryService.categoryByIdService(id),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategoryByIdController(@PathVariable String id,@RequestBody Category data){
        try{
            return new ResponseEntity<>(categoryService.updateCategoryByIdService(id,data),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteByIdController(@PathVariable String id){
        try{
            return new ResponseEntity<>(categoryService.deleteByIdService(id),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
