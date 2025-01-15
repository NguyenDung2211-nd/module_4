package com.codegym.demo_spring_mvc.repository;

import com.codegym.demo_spring_mvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
}
