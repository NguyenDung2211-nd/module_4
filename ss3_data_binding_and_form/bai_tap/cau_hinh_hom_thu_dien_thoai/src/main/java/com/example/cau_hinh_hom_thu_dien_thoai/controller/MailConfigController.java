package com.example.cau_hinh_hom_thu_dien_thoai.controller;

import com.example.cau_hinh_hom_thu_dien_thoai.entity.MailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MailConfigController {

    @GetMapping("/mailConfig")
    public String showConfigForm(Model model) {
        model.addAttribute("mailConfig", new MailConfig());
        return "mailConfigForm";
    }

    @PostMapping("/updateMailConfig")
    public String updateConfig(@ModelAttribute("mailConfig") MailConfig mailConfig, Model model) {
        model.addAttribute("updateMailConfig", mailConfig);
        return "configUpdated";
    }
}

