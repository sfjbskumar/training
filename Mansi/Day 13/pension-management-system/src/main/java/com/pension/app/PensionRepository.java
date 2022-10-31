package com.pension.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.CrudRepository;


import java.util.List;
public interface PensionRepository extends CrudRepository<Pension, Integer>
{


    @Query(value = "select * from pension",nativeQuery = true)
    List<Pension> getPensions();

    @Modifying
    @Query(value="update Pension set name=:'Ajay kumar' where empStatus ='R' and penStatus ='Y' ", nativeQuery = true)
    void updatePensionStatus();
}
