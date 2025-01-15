package com.example.product_management.service;

import com.example.product_management.entity.Product;

import java.util.List;

public interface IService {
    List<Product> findAll();
    void save(Product product);
    void update(Product updateProduct);
    Product getById(int id);
    List<Product> search(String name);
    Product findByIndex(int index);
    void delete(int id);
}
