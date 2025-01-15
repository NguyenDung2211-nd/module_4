package com.example.product_management.controller;

import com.example.product_management.entity.Product;
import com.example.product_management.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Product product
            , RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{index}/update")
    public String update(@PathVariable int index, Model model) {
        Product product = productService.findByIndex(index);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        Product existingProduct = productService.getById(product.getId());
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productService.update(existingProduct);
            redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        } else {
            redirectAttributes.addFlashAttribute("error", "Sản phẩm không có");
        }
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes ) {
       productService.delete(id);
       redirectAttributes.addFlashAttribute("mess", "Xóa sản phẩm");
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        Product Product = productService.getById(id);
        model.addAttribute("product", Product);
        return "detail";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("products", productService.search(name));
        return"list";
    }
}
