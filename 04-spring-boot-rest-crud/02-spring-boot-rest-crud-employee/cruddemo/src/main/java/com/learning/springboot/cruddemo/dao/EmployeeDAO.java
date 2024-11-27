package com.learning.springboot.cruddemo.dao;

import com.learning.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);

    void delete(int employeeId);

}
