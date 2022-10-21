package com.harini.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.harini.demo.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
