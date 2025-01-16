package com.codegym.demo_thymeleaf_c08.repository;

import com.codegym.demo_thymeleaf_c08.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
    TypedQuery<Student> query = entityManager.createQuery("from Student",Student.class);
    return query.getResultList();
    }

    @Override
    public Student findById(int id) {
      return entityManager.find(Student.class,id);
    }


    @Transactional
    @Override
    public boolean save(Student student) {
        try{
            entityManager.persist(student);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
