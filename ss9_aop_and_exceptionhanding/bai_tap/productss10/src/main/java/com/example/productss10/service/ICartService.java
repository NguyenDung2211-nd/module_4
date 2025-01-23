package com.example.productss10.service;

import com.example.productss10.model.Cart;
import com.example.productss10.model.Product;

public interface ICartService {
    boolean checkItemInCart(Product product, Cart cart);
    void addProduct(Product product, Cart cart);
    int countProductQuantity(Cart cart);
    int countItemQuantity(Cart cart);
    float countTotalPayment(Cart cart);
    void updateProductQuantity(Product product, int quantity, Cart cart);
}
