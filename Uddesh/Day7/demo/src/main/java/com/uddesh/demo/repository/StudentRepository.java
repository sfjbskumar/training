package com.uddesh.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.kumar.demo.model.Student;
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
