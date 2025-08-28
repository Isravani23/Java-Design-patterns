package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee employee);

    Employee deleteById(int theId);
}
