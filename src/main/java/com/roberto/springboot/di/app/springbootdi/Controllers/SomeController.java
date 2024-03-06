package com.roberto.springboot.di.app.springbootdi.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roberto.springboot.di.app.springbootdi.models.Product;
import com.roberto.springboot.di.app.springbootdi.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductService service = new ProductService(); 

    @GetMapping
    public List<Product> list(){
        return service.fidnAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }
}
