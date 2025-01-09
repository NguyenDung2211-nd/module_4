package com.codegym.c0924g1.service.impl;

import com.codegym.c0924g1.entity.Student;
import com.codegym.c0924g1.repository.StudentRepository;
import com.codegym.c0924g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
