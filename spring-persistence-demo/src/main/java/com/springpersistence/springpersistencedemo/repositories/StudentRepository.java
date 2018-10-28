package com.springpersistence.springpersistencedemo.repositories;

import com.springpersistence.springpersistencedemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
