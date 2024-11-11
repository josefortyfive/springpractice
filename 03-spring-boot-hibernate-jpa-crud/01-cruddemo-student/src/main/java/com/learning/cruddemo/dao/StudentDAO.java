package com.learning.cruddemo.dao;

import com.learning.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer studentId);

    List<Student> findAll();

    List<Student> findByLastName(String byLastName);

    void update(Student student);
}
