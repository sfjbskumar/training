package com.pension.app.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import com.pension.app.model.Pension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionRepository extends CrudRepository<Pension, Integer>
{
    @Modifying
    @Query("update Pension u set u.empstatus= 'R' " )
    void deactivateUsersNotLoggedInSince();
}
