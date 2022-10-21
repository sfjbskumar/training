package com.sagar.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.sagar.demo.model.Student;
public interface PensionRepository extends CrudRepository<Pension, Integer>
{
}
