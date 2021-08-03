package com.geek.springboothw.controllers;

import com.geek.springboothw.models.Product;
import com.geek.springboothw.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all_products")
    public String showAllProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }


    @GetMapping("/show/{id}")
    public String showProductById(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int cost){
        Product product = new Product(id, title, cost);
        productService.addNewProduct(product);
        return "redirect:/all_products";
    }
}
