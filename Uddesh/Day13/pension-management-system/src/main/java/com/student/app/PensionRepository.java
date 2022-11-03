package com.student.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository("pensionRepo")
public interface PensionRepository extends JpaRepository<Pension, Integer>
{
    @Query("select empStatus from pensions where id=?1")
    String getEmpStatus(int id);

    @Query("select pensionStatus from pensions where id=?1")
    String getPensionStatus(int id);

    @Query("select balance from pensions where id=?1")
    String getBalance(int id);

    @Query("select installment from pensions where id=?1")
    String getInstallment(int id);

    @Query("select pensionMMYY from pensions where id=?1")
    String getPensionMMYY(int id);

    @Modifying
    @Query("update pensions pd set pd.balance=pd.balance-pd.installment, pensionMMYY=?3 where pd.empStatus=?1 and pd.pensionStatus=?2 and pd.pensionMMYY LIKE ?4")
    void issuePension(String empStatus, String pensionStatus, String currentMMYY, String prevMMYY);

    @Modifying
    @Query("update pensions pd set pd.balance=pd.balance+pd.installment, pensionMMYY=?3 where pd.empStatus=?1 and pd.pensionStatus=?2 and pd.pensionMMYY LIKE ?4")
    void loadPension(String empStatus, String pensionStatus, String currentMMYY, String prevMMYY);

    @Modifying
    @Query("update pensions pd set pd.pensionStatus=?1 where pd.id=?2")
    void approveApplication(String pensionStatus, int id);
}