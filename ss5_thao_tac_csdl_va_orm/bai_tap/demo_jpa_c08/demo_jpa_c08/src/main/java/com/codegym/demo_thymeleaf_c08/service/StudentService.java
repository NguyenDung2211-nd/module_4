package com.codegym.demo_thymeleaf_c08.service;

import com.codegym.demo_thymeleaf_c08.model.Student;
import com.codegym.demo_thymeleaf_c08.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }
}
