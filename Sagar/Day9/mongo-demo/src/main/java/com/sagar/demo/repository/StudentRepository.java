package com.sagar.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sagar.demo.model.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
}