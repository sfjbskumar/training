package com.pension.app.repository;
import com.pension.app.model.Pension;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
public interface PensionRepository extends CrudRepository<Pension, Integer>
{
}
