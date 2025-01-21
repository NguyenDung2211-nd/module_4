package com.example.song.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SongNotFoundException.class)
    public ModelAndView handleBlogNotFoundException(SongNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return new ModelAndView("404");
    }
}
