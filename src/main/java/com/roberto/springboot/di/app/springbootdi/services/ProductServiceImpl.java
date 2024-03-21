package com.roberto.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.roberto.springboot.di.app.springbootdi.models.Product;
import com.roberto.springboot.di.app.springbootdi.repositories.ProductRepository;

@Primary
@Service
public class ProductServiceImpl implements ProductService {

    @Value("${config.price.tax}")
    private Double tax;

    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productRepositoryJson") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product>findAll(){
        return repository.findAll().stream().map(p->{
            Double priceTax = p.getPrice() * tax;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd ;
            
            
            //Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

    
}
