package com.pension.app;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pension.app.Pension;
import com.pension.app.PensionRepository;

@Service
public class PensionService
{
    @Autowired
    PensionRepository pensionRepository;
    Pension pension1;
    //getting all student records
    public List<Pension> getAllPension()
    {
        List<Pension> pensions = new ArrayList<Pension>();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        return pensions;
    }
    //getting a specific record
    public Pension getPensionById(int id)
    {
        return pensionRepository.findById(id).get();
    }
    public void saveOrUpdate(Pension pension)
    {
        pensionRepository.save(pension);
    }
    //deleting a specific record
    public void delete(int id)
    {
        pensionRepository.deleteById(id);
    }

    public List<Pension> getPensionByEmpPenStatus(String empStatus, String pensionStatus){
        List<Pension> pensions = new ArrayList<Pension>();
        List<Pension> getPens = new ArrayList<Pension>();
        String es = pension1.getEmpStatus();
        String ps = pension1.getPensionStatus();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        for(int i=0;i<pensions.size();i++){
            if(pensions.get(i).getEmpStatus().equals(es) && pensions.get(i).getEmpStatus().equals(ps)){
                getPens.add(pensions.get(i));
            }
        }
        return getPens;
    }
}

