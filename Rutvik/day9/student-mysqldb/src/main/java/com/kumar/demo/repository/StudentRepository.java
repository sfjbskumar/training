package com.kumar.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.kumar.demo.model.Student;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends CrudRepository<Student, Integer>
{

}
