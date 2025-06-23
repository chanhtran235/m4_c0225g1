package com.example.demo_spring_mvc.service;

import com.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add (Student student);
    Student findById(int id);
}
