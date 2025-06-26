package com.example.demo_spring_data_jap.controller;

import com.example.demo_spring_data_jap.dto.StudentRequestDto;
import com.example.demo_spring_data_jap.entity.Student;
import com.example.demo_spring_data_jap.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;
//    @GetMapping("")
//    public String showList(@PageableDefault(page = 0,size = 2,sort ="name",direction = Sort.Direction.ASC) Pageable pageable, Model model){
//        Page<Student> studentPage = studentService.findAll(pageable);
//        model.addAttribute("studentPage", studentPage);
//        return "student/list";
//    }

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "2") int size,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name").and(Sort.by(Sort.Direction.DESC, "gender"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> studentPage = studentService.search(searchName, pageable);
        model.addAttribute("searchName", searchName);
        model.addAttribute("studentPage", studentPage);
        return "student/list";
    }

    @GetMapping("/detail")
    public String detail1(@RequestParam(name = "id", required = false, defaultValue = "2") int id1, Model model) {
        model.addAttribute("student", studentService.findById(id1));
        return "student/detail";
    }

    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("studentRequestDto", new StudentRequestDto());
        return "student/add";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute StudentRequestDto studentRequestDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        Student student = new Student();
        new StudentRequestDto().validate(studentRequestDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "student/add";
        }
        BeanUtils.copyProperties(studentRequestDto, student);
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess", "add success");
        return "redirect:/students";
    }
}
