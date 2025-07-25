package com.kumom.spingboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kumom.spingboot_di.models.Product;
import com.kumom.spingboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productFoo") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll(); 
    }

    @Override
    public List<Product> findAllAddImp(){
        return repository.findAll().stream().map(t -> {
          
            Double priceTax = t.getPrice() * 1.25d;

            // Product newProduct = new Product(t.getId(), t.getName(), priceTax.longValue());
            
            Product newProduct = (Product) t.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findByIProduct(Long id){
        return repository.findByIProduct(id);
    }

}
