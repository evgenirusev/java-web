package com.springpersistence.springpersistencedemo.services;

import com.springpersistence.springpersistencedemo.entities.Student;
import com.springpersistence.springpersistencedemo.models.binding.CreateStudentBindingModel;

import java.util.Set;

public interface StudentService {
    boolean create(CreateStudentBindingModel createStudentBindingModel);

    Set<Student> getAll();
}
