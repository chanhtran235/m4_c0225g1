package com.example.demo_spring_mvc.repository;

import com.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void add (Student student);
    Student findById(int id);
}
