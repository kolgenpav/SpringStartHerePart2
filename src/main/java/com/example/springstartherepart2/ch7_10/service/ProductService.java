package com.example.springstartherepart2.ch7_10.service;

import com.example.springstartherepart2.ch7_10.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * List of products.
 */
@Service
public class ProductService {
    /*List is final because of BeanDefinition.SCOPE_SINGLETON by default
    * and it can use only one thread*/
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts(){
        return products;
    }
}
