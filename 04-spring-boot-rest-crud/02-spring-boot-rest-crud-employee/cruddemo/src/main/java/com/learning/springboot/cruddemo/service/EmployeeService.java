package com.learning.springboot.cruddemo.service;

import com.learning.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
