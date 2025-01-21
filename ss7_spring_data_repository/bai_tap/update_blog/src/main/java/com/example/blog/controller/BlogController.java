package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.IService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

//    @GetMapping("")
//    public ModelAndView viewAllBlog(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
//        return new ModelAndView("list", "blog", blogService.findAll(page,2));
//    }

    @GetMapping("")
    public ModelAndView viewAllBlog(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "name", required = false) String name) {

        ModelAndView modelAndView = new ModelAndView("list");
        Page<Blog> blogs;
        String mess = "";

        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "createdAt"));

        if (name != null && !name.isEmpty()) {
            blogs = blogService.findByNameContaining(name, pageable);
            if (blogs.isEmpty()) {
                mess = "Không có kết quả tìm kiếm với từ khóa: " + name;
            }
        } else {
            blogs = blogService.findAll(pageable);
            if (blogs.isEmpty()) {
                mess = "Danh sách Blog hiện tại trống.";
            }
        }

        modelAndView.addObject("blog", blogs);
        modelAndView.addObject("name", name);
        modelAndView.addObject("mess", mess);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "create";
    }

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

    @PostMapping("/{id}/update")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(id, blog);
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công.");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String viewDetail(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "view";
    }
}
