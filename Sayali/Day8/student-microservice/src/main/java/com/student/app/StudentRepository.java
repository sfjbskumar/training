package com.student.app;

import org.springframework.data.repository.CrudRepository;
import com.student.app.Student;
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
