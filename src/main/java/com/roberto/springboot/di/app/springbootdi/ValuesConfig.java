package com.roberto.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.roberto.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.roberto.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource(value="classpath:config.properties",encoding = "UTF-8")
})
public class ValuesConfig {

    @Bean
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }

}
