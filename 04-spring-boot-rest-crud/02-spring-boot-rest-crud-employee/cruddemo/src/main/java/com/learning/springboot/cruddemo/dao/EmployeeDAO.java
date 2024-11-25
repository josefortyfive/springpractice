package com.learning.springboot.cruddemo.dao;

import com.learning.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
