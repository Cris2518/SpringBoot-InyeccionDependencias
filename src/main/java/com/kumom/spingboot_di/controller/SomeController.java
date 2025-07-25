package com.kumom.spingboot_di.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumom.spingboot_di.models.Product;
import com.kumom.spingboot_di.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public List<Product> listProducts() {
        return service.findAll();
    }

    @GetMapping("/productsImp")
    public List<Product> listoProductsImProducts() {
        return service.findAllAddImp();
    }
    
    @GetMapping("/{id}")
    public Product showProduct(@PathVariable Long id) {
        return service.findByIProduct(id);
    }
    
}
