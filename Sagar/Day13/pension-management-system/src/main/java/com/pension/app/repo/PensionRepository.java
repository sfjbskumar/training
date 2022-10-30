package com.pension.app.repo;

import com.pension.app.model.Pension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionRepository extends CrudRepository<Pension, Integer>
{

}
