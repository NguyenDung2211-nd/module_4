package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @RequestMapping("/")
    public String showForm() {
        return "sandwich";
    }

    @RequestMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment", required = false) String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("sandwich");
        boolean submitted = false;

        if (condiment == null || condiment.length == 0) {
            modelAndView.addObject("error", "You must select at least one condiment!");
        } else {
            modelAndView.addObject("condiments", condiment);
        }

        submitted = true;
        modelAndView.addObject("submitted", submitted);
        return modelAndView;
    }
}
