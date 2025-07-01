package com.example.demo_spring_data_jap.rest_controller;


import com.example.demo_spring_data_jap.dto.StudentRequestDto;
import com.example.demo_spring_data_jap.entity.Student;
import com.example.demo_spring_data_jap.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class RestStudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 => thành không không trả về gí trị
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK); // 200
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getAll(@PathVariable int id){
        Student student = studentService.findById(id);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 => không tìm thấy
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Student> save(@RequestBody StudentRequestDto studentRequestDto){
        // kiem tra tính hợp lệ dữ liệu
        // nếu ko ok => thì xử lý thế nào => tự tìm hiểu
        // nếu ok => thêm mới
        Student student = new Student();
        BeanUtils.copyProperties(studentRequestDto, student);
        studentService.add(student);
        return new ResponseEntity<>(HttpStatus.CREATED); // 201 => thêm  thành công
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> save(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){

        Student student = studentService.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(studentRequestDto, student);
        studentService.add(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 => thành công nhưng không trả về giá trị
    }

}
