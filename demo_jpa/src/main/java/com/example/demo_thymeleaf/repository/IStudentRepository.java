package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void add (Student student);
    Student findById(int id);
}
