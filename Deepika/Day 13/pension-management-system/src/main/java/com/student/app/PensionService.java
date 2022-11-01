package com.student.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PensionService
{
    @Autowired
    PensionRepository pensionRepository;

    public List<Pension> getAllPension()
    {
        List<Pension> pensions = new ArrayList<Pension>();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        return pensions;
    }

    public Pension getPensionById(int id){
        return pensionRepository.findById(id).get();
    }


    public Pension saveOrUpdate(Pension pension1)
    {
        pensionRepository.save(pension1);
        return pension1;

    }

    public void delete(int id)
    {
        pensionRepository.deleteById(id);
    }

}
