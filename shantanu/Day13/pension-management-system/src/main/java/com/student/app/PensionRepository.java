package com.student.app;

import org.springframework.data.repository.CrudRepository;
import com.sagar.demo.model.Student;
public interface PensionRepository extends CrudRepository<com.Pension.app.Pension, Integer>
{
}
