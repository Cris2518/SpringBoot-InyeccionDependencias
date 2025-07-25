package com.kumom.spingboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.kumom.spingboot_di.models.Product;

@Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Minitor Azus 27", 600L));
    }

    @Override
    public Product findByIProduct(Long id) {
        return new Product(id, "Minitor Azus 27", 600L);
    }
}
