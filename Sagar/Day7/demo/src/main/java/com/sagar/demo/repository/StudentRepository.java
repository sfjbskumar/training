package com.sagar.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.sagar.demo.model.Student;
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
