package com.roberto.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.roberto.springboot.di.app.springbootdi.models.Product;
import com.roberto.springboot.di.app.springbootdi.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product>fidnAll(){
        return repository.findAll().stream().map(p->{
            Double priceTax = p.getPrice() * 1.25d;
            // Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd ;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }
}
