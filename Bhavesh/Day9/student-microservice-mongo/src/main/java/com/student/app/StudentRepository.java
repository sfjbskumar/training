package com.student.app;

//import org.springframework.data.repository.CrudRepository;
import com.student.app.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
}


