package com.pension.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.CrudRepository;




public interface PensionRepository extends CrudRepository<Pension, Integer>
{
    @Query("select empStatus from pensiondetails where id=?1")
    String getEmpStatus(int id);

    @Query("select pensionStatus from pensiondetails where id=?1")
    String getPensionStatus(int id);

    @Query("select balance from pensiondetails where id=?1")
    String getBalance(int id);

    @Query("select installment from pensiondetails where id=?1")
    String getInstallment(int id);

    @Query("select pensionMMYY from pensiondetails where id=?1")
    String getPensionMMYY(int id);
    @Modifying
    @Query("update Pension u set u.empstatus= 'R' " )
    void deactivateUsersNotLoggedInSince();
    @Modifying
    @Query("update pensiondetails pd set pd.balance=pd.balance-pd.installment, pensionMMYY=?3 where pd.empStatus=?1 and pd.pensionStatus=?2 and pd.pensionMMYY LIKE ?4")
    void issuePension(String empStatus, String pensionStatus, String currentMMYY, String prevMMYY);

    @Modifying
    @Query("update pensiondetails pd set pd.balance=pd.balance+pd.installment, pensionMMYY=?3 where pd.empStatus=?1 and pd.pensionStatus=?2 and pd.pensionMMYY LIKE ?4")
    void loadPension(String empStatus, String pensionStatus, String currentMMYY, String prevMMYY);

    @Modifying
    @Query("update pensiondetails pd set pd.pensionStatus=?1 where pd.id=?2")
    void approveApplication(String pensionStatus, int id);
}


