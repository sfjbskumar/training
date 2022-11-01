package com.pension.app;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PensionService
{
    @Autowired
    PensionRepository pensionRepository;

    //getting all pension records
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


}






