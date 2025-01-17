package com.codegym.c0924g1_spring_boot.controller;

import com.codegym.c0924g1_spring_boot.model.Student;
import com.codegym.c0924g1_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ModelAndView viewAllStudent(Model model) {
        return new ModelAndView("student/list", "students", studentService.getAll());
    }

    @GetMapping("/create")
    public String viewAddStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classrooms", new String[] {"1","2", "3"});
        return "student/add";
    }

    @PostMapping("/create")
    public String addStudent(@ModelAttribute("student")Student student,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
             model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("classrooms", new String[] {"1","2", "3"});
            return "student/add";
        }
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create student successfully!");
        return "redirect:/student";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable(name = "id") int id,
                                RedirectAttributes redirectAttributes) {
        studentService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete student successfully");
        return "redirect:/student";
    }
}
