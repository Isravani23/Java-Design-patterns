package com.sravExample.cruddemo.dao;

import com.sravExample.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //define field for entity manager
    private EntityManager entityManager;
    //inject em using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    //implement save method
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
        //return query res
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findbyFirstName(String theFirstName) {
        //create query
        TypedQuery<Student> theQuery1 = entityManager.createQuery("From Student where first_name=:theData",Student.class);
        //set query parameter
        theQuery1.setParameter("theData",theFirstName);
        return theQuery1.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
       entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the stud
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}
