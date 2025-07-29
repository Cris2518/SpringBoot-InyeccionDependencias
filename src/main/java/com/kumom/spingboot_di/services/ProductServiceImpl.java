package com.kumom.spingboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kumom.spingboot_di.models.Product;
import com.kumom.spingboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Value("${config.price.tax}")
    private Double Tax;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll(); 
    }

    @Override
    public List<Product> findAllAddImp(){
        return repository.findAll().stream().map(t -> {
          
            Double priceTax = t.getPrice() * Tax;

            // Product newProduct = new Product(t.getId(), t.getName(), priceTax.longValue());
            
            Product newProduct = (Product) t.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

            // t.setPrice(priceTax.longValue());
            // return t;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findByIProduct(Long id){
        return repository.findByIProduct(id);
    }

}
