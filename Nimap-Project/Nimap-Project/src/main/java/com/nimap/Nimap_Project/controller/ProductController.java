package com.nimap.Nimap_Project.controller;

import com.nimap.Nimap_Project.entity.Category;
import com.nimap.Nimap_Project.entity.Product;
import com.nimap.Nimap_Project.service.CategoryService;
import com.nimap.Nimap_Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProductController(@RequestBody Product product_data){
        try{
            productService.createProductService(product_data);
            return new ResponseEntity<>(product_data, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProductController(@RequestParam("page") Integer page){
        return new ResponseEntity<>(productService.getAllProductService(page),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> productByIdController(@PathVariable String id){
        try{
            return new ResponseEntity<>(productService.productByIdService(id),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductByIdController(@PathVariable String id,@RequestBody Product data){
        try{
            return new ResponseEntity<>(productService.updateProductByIdService(id,data),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProductByIdController(@PathVariable String id){
        try{
            return new ResponseEntity<>(productService.deleteByIdService(id),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
}

