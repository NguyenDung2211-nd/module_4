package com.example.productss10.model;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public int countItemQuantity() {
        return products.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int countProductQuantity() {
        return products.size();
    }


    public BigDecimal countTotalPayment() {
        BigDecimal totalPayment = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            BigDecimal price = BigDecimal.valueOf(product.getPrice());
            totalPayment = totalPayment.add(price.multiply(BigDecimal.valueOf(quantity)));
        }

        return totalPayment;
    }
}