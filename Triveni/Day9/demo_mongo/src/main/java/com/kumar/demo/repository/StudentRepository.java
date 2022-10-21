package com.kumar.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.kumar.demo.model.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
}
