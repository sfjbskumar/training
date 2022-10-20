package com.kumar.demo.repository;


import com.kumar.demo.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
}
