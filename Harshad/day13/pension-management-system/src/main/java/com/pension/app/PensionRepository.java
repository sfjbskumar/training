package com.pension.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.CrudRepository;
import com.pension.app.Pension;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PensionRepository extends CrudRepository<Pension, Integer>
{
    @Modifying
    @Query("update Pension u set u.empstatus= 'R' " )
    void deactivateUsersNotLoggedInSince();
}


Stream.of(new pension(201,"sivani",21,8000,"7684925464","A","N",0922,1000)).collect(Collectors.total);
assertEquals(2,pensionService.getApplicants().size());