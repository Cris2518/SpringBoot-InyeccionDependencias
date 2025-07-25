package com.kumom.spingboot_di.repositories;

import java.util.List;

import com.kumom.spingboot_di.models.Product;

public interface ProductRepository {

    List<Product> findAll();

    Product findByIProduct(Long id);
}
