package com.kumom.spingboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.kumom.spingboot_di.repositories.ProductRepository;
import com.kumom.spingboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
