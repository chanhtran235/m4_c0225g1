package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student ",Student.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void add(Student student) {
          entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

}
