package com.example.quan_li_san_pham.service.impl;

import com.example.quan_li_san_pham.entity.Product;
import com.example.quan_li_san_pham.repository.ProductRepository;
import com.example.quan_li_san_pham.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
