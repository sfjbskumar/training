package com.practice.miniproject.service;

import com.practice.miniproject.PensionRepository;
import com.practice.miniproject.model.PensionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PensionService {
    @Autowired
    PensionRepository pensionRepository;
    //getting all student records
    public List<PensionModel> getAllPension()
    {
        List<PensionModel> pensions = new ArrayList<PensionModel>();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        return pensions;
    }
    //getting a specific record
    public PensionModel getPensionById(int id)
    {
        return pensionRepository.findById(id).get();
    }
    public PensionModel saveOrUpdate(PensionModel pension)
    {
        pensionRepository.save(pension);
        return pension;
    }
    //deleting a specific record
    public void delete(int id)
    {
        pensionRepository.deleteById(id);

    }
}



