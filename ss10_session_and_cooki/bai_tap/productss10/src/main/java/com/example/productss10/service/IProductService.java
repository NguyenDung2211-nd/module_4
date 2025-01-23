package com.example.productss10.service;

import com.example.productss10.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(int id);
    void addNewProduct(Product product);
}
