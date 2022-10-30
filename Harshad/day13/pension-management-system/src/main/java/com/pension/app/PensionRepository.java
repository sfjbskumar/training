package com.pension.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PensionRepository extends CrudRepository<Pension, Integer> {
    @Modifying
   @Query(value="update pension set name=:k where empstatus =:n and penstatus =:m", nativeQuery = true)
    void updatePensionStatus(@Param("k") String name, @Param("n") String empstatus, @Param("m") String penstatus);

    @Query(value = "select * from pension", nativeQuery = true)
    public List<Pension> getPensions();

    @Modifying
    @Query(value = "update Pension set name=:'jish kumar' where empstatus ='R' and penstatus ='Y' ", nativeQuery = true)
    void updatePensionStatus();


}