package com.example.books.exception;


import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookHandleException {
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "redirect:/home";
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public String handleDuplicateKeyException(DuplicateKeyException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "redirect:/home";
    }
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", "Đã xảy ra lỗi không mong muốn: " + e.getMessage());
        return "redirect:/home";
    }
}
