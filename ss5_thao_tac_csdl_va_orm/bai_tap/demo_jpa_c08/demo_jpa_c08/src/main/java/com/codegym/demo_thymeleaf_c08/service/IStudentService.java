package com.codegym.demo_thymeleaf_c08.service;

import com.codegym.demo_thymeleaf_c08.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
}
