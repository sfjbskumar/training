package com.pension.app.service;

import java.util.ArrayList;
import java.util.List;
import com.pension.app.repository.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pension.app.model.Pension;

@Service
public class PensionService
{
    @Autowired
    PensionRepository pensionRepository;
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
}
