package com.roberto.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roberto.springboot.di.app.springbootdi.models.Product;

@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria Corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer 60%", 180L),
            new Product(4L, "Motherboard Gygabite", 490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }
    
    @Override
    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
