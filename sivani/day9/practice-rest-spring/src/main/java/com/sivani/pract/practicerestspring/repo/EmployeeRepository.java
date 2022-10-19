package com.sivani.pract.practicerestspring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sivani.pract.practicerestspring.models.Emp;
@Repository
public interface EmployeeRepository extends CrudRepository<Emp, Integer>
{
}
