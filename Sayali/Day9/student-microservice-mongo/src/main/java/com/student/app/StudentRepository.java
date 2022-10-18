package com.student.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.student.app.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
}

