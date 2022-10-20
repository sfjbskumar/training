package com.kumar.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.kumar.demo.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
