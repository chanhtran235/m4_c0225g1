package com.example.demo_spring_data_jap.aop;

import com.example.demo_spring_data_jap.dto.StudentRequestDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;

    //    @After("execution(* com.example.demo_spring_data_jap.controller.StudentController.*(..))")
//    public void countUserVisitedListStudent(){
//        count++;
//        System.out.println("---------aop-------list -----------running----------");
//    }
//    @AfterThrowing("execution(* com.example.demo_spring_data_jap.controller.StudentController.save(..))")
//    public void loggerAddStudentThrowException() {
//        System.out.println("--------Exception of DuplicateAdmin----------");
//    }

//    @AfterReturning("execution(* com.example.demo_spring_data_jap.controller.StudentController.save(..))")
//    public void loggerAddStudentSuccess(JoinPoint joinPoint) {
//        Object[] objects = joinPoint.getArgs();
//        StudentRequestDto studentRequestDto = (StudentRequestDto) objects[0];
//        System.out.println("---------------------Thêm mới thành công sinh viên: -------------------------");
//        System.out.println("student name :" + studentRequestDto.getName());
//    }

    @Around("execution(* com.example.demo_spring_data_jap.controller.StudentController.save(..))")
    public Object loggerAddStudentAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----logic chạy trước khi nghiệp vụ chính chạy-------");
        Object object = joinPoint.proceed();
        System.out.println("----logic chạy sau khi nghiệp vụ chính chạy-------");
        return object;
    }

}
