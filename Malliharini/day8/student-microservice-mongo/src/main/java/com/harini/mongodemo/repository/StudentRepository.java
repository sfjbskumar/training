package com.harini.mongodemo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.harini.mongodemo.model.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
}
