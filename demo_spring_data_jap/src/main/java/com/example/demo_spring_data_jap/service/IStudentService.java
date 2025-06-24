package com.example.demo_spring_data_jap.service;

import com.example.demo_spring_data_jap.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add (Student student);
    Student findById(int id);
}
