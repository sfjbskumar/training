package com.harini.mysqldemo.repository;

import org.springframework.data.repository.CrudRepository;
import com.harini.mysqldemo.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
