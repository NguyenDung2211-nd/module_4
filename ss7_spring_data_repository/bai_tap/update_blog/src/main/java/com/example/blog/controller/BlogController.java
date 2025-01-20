package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.IService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView viewAllBlog(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        return new ModelAndView("list", "blog", blogService.findAll(page,2));
    }

//    @GetMapping("")
//    public String list(@PageableDefault(value = 5) Pageable pageable,
//                       Model model, Optional<String> name, Optional<Integer> categoryId  ){
//
//        model.addAttribute("categoryList",categoryService.findAll());
//        if (!name.isPresent() || name.get().equals("")){
//            if (!categoryId.isPresent()){
//                model.addAttribute("blog",blogService.findAll(pageable));
//            }else {
//                model.addAttribute("categoryId",categoryId.get());
//                model.addAttribute("blog",blogService.findBlogByCategoryId(categoryId.get(), pageable));
//            }
//        }else if (!categoryId.isPresent()){
//            model.addAttribute("name",name.get());
//            model.addAttribute("blog",blogService.findByNameContaining(name.get(), pageable));
//        }else {
//            model.addAttribute("name",name.get());
//            model.addAttribute("categoryId",categoryId.get());
//            model.addAttribute("blog",blogService.findByNameContainingAndCategoryId(name.get(),
//                    categoryId.get(),pageable));
//
//        }
//        return "list";
//    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "create";
    }

//    @PostMapping("/create")
//    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
//        blogService.save(blog);
//        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công.");
//        return "redirect:/blog";
//    }

    @PostMapping("/create")
    public String addBlog(@ModelAttribute("blog")Blog blog,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("categoryList", categoryService.findAll());
            return "create";
        }
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công.");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/update")
    public String showEdit(Model model, @PathVariable Integer id) {
        Blog blog = blogService.findById(id).get();
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList",categoryService.findAll());
        return "update";
    }

//    @PostMapping("/{id}/update")
//    public String edit(@PathVariable("id") Integer id, @ModelAttribute Blog blog, @RequestParam("categoryId") Integer categoryId, RedirectAttributes redirectAttributes) {
//        Category category = categoryService.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Category không tồn tại"));
//        blog.setCategory(category);
//        blogService.update(id, blog);
//        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công.");
//        return "redirect:/blog";
//    }

    @PostMapping("/{id}/update")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute Blog blog, @RequestParam("categoryId") Integer categoryId, RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Category not found"));
        blog.setCategory(category);
        blogService.update(id, blog);
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công.");
        return "redirect:/blog";
    }

//    @PostMapping("/{id}/update")
//    public String edit(@PathVariable("id") Integer id, @ModelAttribute Blog blog, @RequestParam("categoryId") Integer categoryId, RedirectAttributes redirectAttributes) {
//        Category category = categoryService.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Category not found"));
//        blog.setCategory(category);
//        blogService.update(id, blog);
//        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công.");
//        return "redirect:/blog";
//    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa sản phẩm thành công");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String viewDetail(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "view";
    }
}
