package com.example.blog.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BlogNotFoundException.class)
    public ModelAndView handleBlogNotFoundException(BlogNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return new ModelAndView("error/404");
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ModelAndView handleCategoryNotFoundException(CategoryNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return new ModelAndView("error/404");
    }
}
