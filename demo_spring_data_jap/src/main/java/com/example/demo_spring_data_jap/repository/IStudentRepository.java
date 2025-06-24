package com.example.demo_spring_data_jap.repository;

import com.example.demo_spring_data_jap.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findStudentByNameContaining(String searchName);

    @Query(value = "select * from students where name like concat('%',:searchName,'%');",nativeQuery = true)
    List<Student> searchByName(@Param("searchName") String searchName);

}
