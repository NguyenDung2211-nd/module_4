package com.example.product.controller;

import com.example.product.entity.Cart;
import com.example.product.entity.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart,
                            @RequestParam(value = "action", required = false, defaultValue = "") String action,
                            Model model) {
        Optional<Product> product=productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        if (action.equals("+")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("-")) {
            cart.decreaseProduct(product.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("x")) {
            cart.removeProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        model.addAttribute("smg","added to cart");
        return "redirect:/view/"+id;
    }

    @GetMapping("/view/{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<Product> product=productService.findById(id);
        product.ifPresent(value -> model.addAttribute("product", value));
        return "/view";
    }
}
