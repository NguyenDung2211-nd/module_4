package com.example.quan_li_san_pham.repository;

import com.example.quan_li_san_pham.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public static List<Product> product = new ArrayList<>();

    static{
        product.add(new Product(1,"IPhone 11", 12000000, 2,"Apple"));
        product.add(new Product(2,"IPhone 12", 14000000, 3,"Apple"));
        product.add(new Product(3,"IPhone 13", 16000000, 4,"Apple"));
        product.add(new Product(4,"IPhone 14", 18000000, 5,"Apple"));
        product.add(new Product(5,"IPhone 15", 20000000, 6,"Apple"));
    }

    public List<Product> findAll(){
        return product;
    }


}
