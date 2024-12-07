package com.nimap.Nimap_Project.service;
import com.nimap.Nimap_Project.entity.Product;
import com.nimap.Nimap_Project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProductService(Product productData) {
        productRepository.save(productData);

    }

    public List<Product> getAllProductService(Integer page) {
        return (List<Product>) productRepository.findAll();
    }

    public Object productByIdService(String id) {
        return productRepository.findById(id);
    }

    public Object updateProductByIdService(String id, Product data) {
        Optional<Product> product=productRepository.findById(id);
        if(product.isPresent()){
            Product category1=product.get();
            category1.setProduct_name(data.getProduct_name());
            category1.setUpdated_at(data.getUpdated_at());
            category1.setCreated_at(data.getCreated_at());
            category1.setModified_by(data.getModified_by());
            productRepository.save(category1);
            return "Updated Successfully";
        }
        else{
            return "NOT FOUND";
        }
    }

    public Object deleteByIdService(String id) {
        Optional<Product> product=productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return "Deleted Successfully";
        }
        else{
            return "NOT FOUND";
        }
    }
}
