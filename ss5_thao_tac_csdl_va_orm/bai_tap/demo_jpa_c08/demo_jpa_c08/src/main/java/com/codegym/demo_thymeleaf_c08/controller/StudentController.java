package com.codegym.demo_thymeleaf_c08.controller;


import com.codegym.demo_thymeleaf_c08.model.Student;
import com.codegym.demo_thymeleaf_c08.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String showList(ModelMap model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "student/list";
    }

    @GetMapping("/detail")
    public String detail1(@RequestParam(required = false,defaultValue = "3") int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "student/detail";
    }
    @GetMapping("/detail/{id}")
//    @GetMapping("/detail/{id:[1-2]}")
    public String detail2(@PathVariable(name = "id",required = false) int detailId, Model model){
        model.addAttribute("student",studentService.findById(detailId));
        return "student/detail";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("student", new Student());
        return "student/create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute  Student student, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","add success");
        studentService.save(student);
        return "redirect:/students";
    }
}
