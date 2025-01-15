package com.codegym.demo_spring_mvc.service;

import com.codegym.demo_spring_mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
}
