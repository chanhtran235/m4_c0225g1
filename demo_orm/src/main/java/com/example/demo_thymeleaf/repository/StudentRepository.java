package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh1",true, "C02"));
        studentList.add(new Student(2,"chánh1",true, "C02"));
        studentList.add(new Student(3,"chánh1",true, "C02"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i <studentList.size() ; i++) {
            if (id==studentList.get(i).getId()){
                return studentList.get(i);
            }
        }
        return null;
    }

}
