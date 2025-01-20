package com.example.blog.advice;

import com.example.blog.exception.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFound(ResourceNotFoundException ex, Model model) {
        ModelAndView modelAndView = new ModelAndView("/404");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}
