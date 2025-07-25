package com.kumom.spingboot_di.services;

import java.util.List;

import com.kumom.spingboot_di.models.Product;

public interface ProductService {

    List<Product> findAll();

    List<Product> findAllAddImp();

    Product findByIProduct(Long id);
}