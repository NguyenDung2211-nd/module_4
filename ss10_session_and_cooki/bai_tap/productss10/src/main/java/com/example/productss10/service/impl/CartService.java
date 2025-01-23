package com.example.productss10.service.impl;

import com.example.productss10.model.Cart;
import com.example.productss10.model.Product;
import com.example.productss10.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {

    @Override
    public boolean checkItemInCart(Product product, Cart cart) {
        return cart.getProducts().containsKey(product);
    }

    @Override
    public void addProduct(Product product, Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    @Override
    public int countProductQuantity(Cart cart) {
        return cart.getProducts().values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public int countItemQuantity(Cart cart) {
        return cart.getProducts().size();
    }

    @Override
    public float countTotalPayment(Cart cart) {
        return (float) cart.getProducts().entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }
    @Override
    public void updateProductQuantity(Product product, int quantity, Cart cart) {
        if (cart.getProducts().containsKey(product)) {
            if (quantity > 0) {
                cart.getProducts().put(product, quantity);
            } else {
                cart.getProducts().remove(product);
            }
        }
    }
}
