package com.codegym.demo_spring_mvc.service;

import com.codegym.demo_spring_mvc.model.Student;
import com.codegym.demo_spring_mvc.repository.IStudentRepository;
import com.codegym.demo_spring_mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
