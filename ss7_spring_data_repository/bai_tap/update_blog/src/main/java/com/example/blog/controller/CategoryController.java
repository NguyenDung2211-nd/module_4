package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String viewCategory(Model model){
        List<Category> category = categoryService.findAll();
        if(category.isEmpty()){
            model.addAttribute("mess", "Category is empty" );
        }else {
            model.addAttribute("category", category);
        }
        return "category/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công.");
        return "redirect:/category";
    }

    @GetMapping("/{id}/update")
    public String formUpdate(@PathVariable ("id") Integer id, Model model){
        Category category = categoryService.findById(id).get();
        model.addAttribute("category", category);
        return "category/update";
    }

    @PostMapping("/{id}/update")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.update(id, category);
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công.");
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/category";
    }

    @GetMapping("/{id}/view")
    public String viewDetail(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id).get();
        model.addAttribute("category", category);
        return "category/view";
    }
}
