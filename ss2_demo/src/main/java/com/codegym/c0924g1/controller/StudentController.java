package com.codegym.c0924g1.controller;

import com.codegym.c0924g1.entity.Student;
import com.codegym.c0924g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

//    Field DI
//    Constructor
//    Setter
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ModelAndView viewAll(Model model) {
//        List<Student> students = studentService.findAll();
//        model.addAttribute("students", students);
//        return "student/list";
        return new ModelAndView("student/list", "students", studentService.findAll());
    }

    @GetMapping("/create")
    public String viewAdd() {
        return "student/create";
    }

    @PostMapping("/create")
    public String addStudent(@RequestParam String name, @RequestParam Double point,
                             @RequestParam String className, @RequestParam String address,
                             RedirectAttributes redirect) {
        Student student = new Student(name, address,point, className);
        studentService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String removeStudent(@PathVariable(name = "id")Long id,
                                RedirectAttributes redirect) {
//        logic xóa theo id
        redirect.addFlashAttribute("messgae", "Xóa thành công");
        return "redirect/students";
    }


}
