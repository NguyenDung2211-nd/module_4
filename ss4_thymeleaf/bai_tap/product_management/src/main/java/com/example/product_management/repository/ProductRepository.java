package com.example.product_management.repository;

import com.example.product_management.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("IPhone 11", 12000000, "Tốt"));
        products.add(new Product("IPhone 12", 14000000, "Tốt"));
        products.add(new Product("IPhone 13", 16000000, "Tốt"));
        products.add(new Product("IPhone 14", 18000000, "Tốt"));
        products.add(new Product("Samsung", 20000000, "Tốt"));

    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        product.setId(products.get(products.size() - 1).getId());
        products.add(product);
    }

    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product findByIndex(int index) {
        return products.get(index);
    }

    public void update(Product updatedProduct) {
        for (Product product : products) {
            if (product.getId() == updatedProduct.getId()) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setDescription(updatedProduct.getDescription());
                break;
            }
        }
    }

    public void delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }

    public List<Product> search(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}
