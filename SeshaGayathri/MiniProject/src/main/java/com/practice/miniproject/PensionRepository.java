package com.practice.miniproject;

import com.practice.miniproject.model.PensionModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
    public interface PensionRepository extends CrudRepository<PensionModel, Integer>
    {
        PensionModel findByName(String name);
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


