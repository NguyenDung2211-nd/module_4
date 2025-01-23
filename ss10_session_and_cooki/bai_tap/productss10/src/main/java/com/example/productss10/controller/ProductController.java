package com.example.productss10.controller;

import com.example.productss10.model.Cart;
import com.example.productss10.model.Product;
import com.example.productss10.service.IProductService;
import com.example.productss10.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private CartService cartService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("")
    public String shop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }
    @GetMapping("show-add")
    public String showAdd(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("product") Product product,
                      BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getAllErrors());
            return "product";
        }
        if(product.getId() == null || productService.findById(product.getId()) == null){
            productService.addNewProduct(product);
        } else {
            throw new DuplicateKeyException("Product already exists");
        }
        redirectAttributes.addFlashAttribute("message", "Product added successfully");
        return "redirect:/shop";
    }
    @GetMapping("/product/{id}")
    public String viewProductDetail(@PathVariable int id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error";
        }
        model.addAttribute("product", productOptional.get());
        return "detail";
    }
    @PostMapping("/{id}/add_cart")
    public String addToCartAndShow(@PathVariable("id") int id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        Product product = productOptional.get();
        cartService.addProduct(product, cart);
        return "redirect:/shopping_cart";
    }
    @PostMapping("/add_shop")
    public String addToCartAndBackToShop(@PathVariable Integer id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);

        if (!productOptional.isPresent()) {
            return "/error";
        }

        Product product = productOptional.get();
        cartService.addProduct(product, cart);
        return "redirect:/shop";
    }
}
