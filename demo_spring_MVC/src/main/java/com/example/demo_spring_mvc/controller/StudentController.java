package com.example.demo_spring_mvc.controller;

import com.example.demo_spring_mvc.entity.Student;
import com.example.demo_spring_mvc.service.IStudentService;
import com.example.demo_spring_mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @ModelAttribute("subjects")
    public List<String> getAllSubject(){
        return Arrays.asList("js","java","php");
    }
    @Autowired
    private IStudentService studentService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("studentList", studentService.findAll());
        return "student/list";
    }
    @GetMapping("/detail")
    public String detail1(@RequestParam(name = "id",required = false,defaultValue = "2")  int id1, Model model){
        model.addAttribute("student",studentService.findById(id1));
        return "student/detail";
    }
    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "student/detail";
    }
    @GetMapping ("/add")
    public String showFormAdd(Model model){
        model.addAttribute("student", new Student());
        return "student/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Student student ,RedirectAttributes redirectAttributes){
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","add success");
        return "redirect:/students";
    }
}
