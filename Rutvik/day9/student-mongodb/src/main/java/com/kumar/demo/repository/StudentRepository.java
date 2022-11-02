package com.kumar.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.kumar.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.kumar.demo.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>
{
}
