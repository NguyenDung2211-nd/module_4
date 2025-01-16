package com.codegym.demo_thymeleaf_c08.repository;



import com.codegym.demo_thymeleaf_c08.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
}
