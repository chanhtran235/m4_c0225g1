package com.example.demo_spring_data_jap.service;

import com.example.demo_spring_data_jap.entity.Student;
import com.example.demo_spring_data_jap.exception.DuplicateAdminException;
import com.example.demo_spring_data_jap.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        // search
        List<Student> students= studentRepository.findStudentByNameContaining("h");
        return students;
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> search(String name, Pageable pageable) {
        return studentRepository.findStudentByNameContaining(name,pageable);
    }

    @Override
    public void add(Student student) throws DuplicateAdminException {
        if (student.getName().equals("Admin")){
            throw new DuplicateAdminException("Tên đang trùng với admin");
        }

        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
