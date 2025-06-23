package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository {

    @Override
    public List<Student> findAll() {
        // kết nối DB
        Session session = ConnectionUtil.sessionFactory.openSession();
//        TypedQuery<Student> query = session.createQuery("FROM Student",Student.class);
        TypedQuery<Student> query = session.createNativeQuery("select * from students",Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public void add(Student student) {

        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Student> query = session.createNativeQuery("select * from students where id = :id1",Student.class);
        Student student = query.setParameter("id1",id).getSingleResult();
        return   student;
//        return   session.find(Student.class,id);
    }

}
