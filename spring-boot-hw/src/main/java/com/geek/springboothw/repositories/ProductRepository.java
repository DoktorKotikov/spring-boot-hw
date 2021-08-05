package com.geek.springboothw.repositories;

import com.geek.springboothw.models.Product;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Sprite", 33),
                new Product(2L, "Coca-Cola", 44),
                new Product(3L, "Fanta", 55)
        ));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id){
        for(Product p : products){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public void addNewProduct(Product product){
        products.add(product);
    }

    public void minusCost(Long id){
        for(Product p : products) {
            if (p.getId().equals(id)) {
                p.setCost(p.getCost() - 1);
            }
        }
    }


    public void plusCost(Long id){
        for(Product p : products) {
            if (p.getId().equals(id)) {
                p.setCost(p.getCost() + 1);
            }
        }
    }



}
