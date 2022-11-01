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

    public List<Pension> getPensionByEmpPenStatus(String empstatus, String penstatus){
        List<Pension> pensions = new ArrayList<Pension>();
        List<Pension> getPens = new ArrayList<Pension>();
        String es = pension1.getEmpstatus();
        String ps = pension1.getPenstatus();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        for(int i=0;i<pensions.size();i++){
            if(pensions.get(i).getEmpstatus().equals(es) && pensions.get(i).getEmpstatus().equals(ps)){
                getPens.add(pensions.get(i));
            }
        }
        return getPens;
    }
}

