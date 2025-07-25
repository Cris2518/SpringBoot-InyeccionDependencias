package com.kumom.spingboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.kumom.spingboot_di.models.Product;

@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> dataProducts;

    public ProductRepositoryImpl() {
        this.dataProducts = Arrays.asList(
            new Product(1L, "Memoria corsair 32gb", 135L),
            new Product(2L, "CPU Intel Core I5", 850L),
            new Product(3L, "Teclado Razer Mini", 156L),
            new Product(4L, "MotherBoard", 560L)
        );
    }

    @Override
    public List<Product> findAll(){
        return dataProducts;
    }

    @Override
    public Product findByIProduct(Long idProducto){
        return dataProducts.stream().filter(t -> t.getId().equals(idProducto)).findFirst().orElse(null);
    }
}
