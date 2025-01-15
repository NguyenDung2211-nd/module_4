package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        return "redirect:/home";
    }
    @PostMapping("home2")
    public String home2(Model model) {
        return "home";
    }
}
