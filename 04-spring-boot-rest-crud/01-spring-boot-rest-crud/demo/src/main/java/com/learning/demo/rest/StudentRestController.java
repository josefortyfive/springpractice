package com.learning.demo.rest;

import com.learning.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student("Maria", "Elena"));
        students.add(new Student("James", "Mark"));
        students.add(new Student("Mike", "Jordan"));

        return students;
    }

}
