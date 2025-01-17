package com.codegym.c0924g1_spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;

    @Column(name = "name_student", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(name = "score", columnDefinition = "DOUBLE")
    private Float point;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

}
