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
    public String showList(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("products", productService.search(name));
            model.addAttribute("isSearch", true);
        } else {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("isList", false);
        }
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

    @GetMapping("/{id}/update")
    public String editFormUpdate(@PathVariable("id") int id, Model model) {
        Product product = productService.getById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "update";
        }
        return "redirect:/product";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") int id, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId(id);
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin sản phẩm thành công.");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes ) {
       productService.delete(id);
       redirectAttributes.addFlashAttribute("mess", "Xóa sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") int id, Model model){
        Product Product = productService.getById(id);
        model.addAttribute("product", Product);
        return "detail";
    }

}
