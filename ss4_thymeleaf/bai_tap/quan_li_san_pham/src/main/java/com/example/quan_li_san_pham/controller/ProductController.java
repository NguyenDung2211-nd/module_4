package com.example.quan_li_san_pham.controller;

import com.example.quan_li_san_pham.entity.Product;
import com.example.quan_li_san_pham.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        System.out.println(productList);
        model.addAttribute("products", productList);
        return "list";
    }
}
