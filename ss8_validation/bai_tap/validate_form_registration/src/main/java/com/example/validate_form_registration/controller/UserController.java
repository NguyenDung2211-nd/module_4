package com.example.validate_form_registration.controller;

import com.example.validate_form_registration.entity.User;
import com.example.validate_form_registration.service.IService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserController{

    @Autowired
    private IService userService;

    @GetMapping("")
    public String formUser(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "form";
        }else{
            userService.save(user);
            return "result";
        }
    }

}

