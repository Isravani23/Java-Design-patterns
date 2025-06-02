package com.sravExample.cruddemo.dao;

import com.sravExample.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student>findbyFirstName(String theFirstName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();


}
