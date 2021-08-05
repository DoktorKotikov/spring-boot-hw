package com.geek.springboothw.services;

import com.geek.springboothw.models.Product;
import com.geek.springboothw.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }

    public void addNewProduct(Product product){
        productRepository.addNewProduct(product);
    }

    public void minusCost(Long id) {productRepository.minusCost(id);}
    public void plusCost(Long id) {productRepository.plusCost(id);}
}
