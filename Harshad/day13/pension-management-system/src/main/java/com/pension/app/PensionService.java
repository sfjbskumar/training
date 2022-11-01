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
    Pension pension1;
    //getting all Pension records
    public List<Pension> getAllPension()
    {
        List<Pension> pensions = new ArrayList<>();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        return pensions;
    }
    //getting a specific record
    public Pension getPensionById(int id)
    {
        return pensionRepository.findById(id).get();
    }

    //adding a record
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

