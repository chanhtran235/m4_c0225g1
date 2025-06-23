package com.example.demo_spring_mvc.service;

import com.example.demo_spring_mvc.entity.Student;
import com.example.demo_spring_mvc.repository.IStudentRepository;
import com.example.demo_spring_mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void add(Student student) {
        studentRepository.add(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
