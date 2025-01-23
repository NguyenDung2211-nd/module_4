package com.example.productss10.service.impl;

import com.example.productss10.model.Product;
import com.example.productss10.repository.ProductRepository;
import com.example.productss10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }
}
