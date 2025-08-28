package com.example.dao;


import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {
}
