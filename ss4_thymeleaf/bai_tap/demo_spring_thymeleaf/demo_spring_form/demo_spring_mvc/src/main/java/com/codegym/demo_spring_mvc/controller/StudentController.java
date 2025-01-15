package com.codegym.demo_spring_mvc.controller;


import com.codegym.demo_spring_mvc.model.Student;
import com.codegym.demo_spring_mvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @ModelAttribute("languages")
    public String[] getLanguages(){
        System.out.println("-------------dữ liệu được gọi-------------");
        return new String[]{"JAVA","NODEJS","PHP"};
    }

    @GetMapping("")
    public String showList(ModelMap model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }

    @GetMapping("/detail")
    public String detail1(@RequestParam(required = false,defaultValue = "3") int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }
    @GetMapping("/detail/{id}")


    public String detail2(@PathVariable(name = "id",required = false) int detailId, Model model){
        model.addAttribute("student",studentService.findById(detailId));
        return "detail";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("student", new Student());
//        model.addAttribute("languages", new String[]{"JAVA","NODEJS","PHP"});
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Student student
            , RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","add success");
        studentService.save(student);
        return "redirect:/students";
    }
}
