package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IService blogService;

    @GetMapping("/list")
    public ModelAndView list() {
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        if (blogs.isEmpty()) {
            modelAndView.addObject("mess", "Danh sách blog hiện tại trống.");
        } else {
            modelAndView.addObject("blog", blogs);
        }
        return modelAndView;
    }


    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công.");
        return "redirect:/list";
    }

    @GetMapping("/{id}/update")
    public String showEdit(Model model, @PathVariable Integer id) {
        Blog blog = blogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "update";
    }

    @PostMapping("/{id}/update")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.updateBlog(id, blog);
        redirectAttributes.addFlashAttribute("smg", "Sửa thông tin thành công.");
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa sản phẩm thành công");
        return "redirect:/list";
    }

    @GetMapping("/{id}/view")
    public String viewDetail(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "view";
    }


}
