package com.pension.app.Service;

import com.pension.app.Repository.*;
import com.pension.app.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PensionService
{
    @Autowired
    static
    PensionRepository pensionRepository;
     public static List<Pension> applicant_info()
    {
        List<Pension> Pension_applicant = new ArrayList<Pension>();
        pensionRepository.findAll().forEach(applicant -> Pension_applicant.add(applicant));
        return Pension_applicant;
    }
    //getting a specific record
    public static Pension getapplicantById(int applicant_id)
    {
        return pensionRepository.findById(applicant_id).get();
    }
   public void saveOrUpdate(Pension pension)
    {
         pensionRepository.save(pension);
    }
}
