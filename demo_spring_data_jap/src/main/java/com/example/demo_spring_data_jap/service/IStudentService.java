package com.example.demo_spring_data_jap.service;

import com.example.demo_spring_data_jap.entity.Student;
import com.example.demo_spring_data_jap.exception.DuplicateAdminException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Page<Student> search(String name,Pageable pageable);
    void add (Student student) throws DuplicateAdminException;
    Student findById(int id);
}
