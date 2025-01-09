package com.codegym.c0924g1.repository;

import com.codegym.c0924g1.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "HaTT", "QN", 9, "C0724M1"));
        students.add(new Student(3, "HaTT1", "QN", 9, "C0724M1"));
        students.add(new Student(5, "HaTT2", "QN", 9, "C0724M1"));
        students.add(new Student(6, "HaTT3", "QN", 9, "C0724M1"));
    }

    public List<Student> findAll() {
        return students;
    }
}
