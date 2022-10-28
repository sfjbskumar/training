package com.pension.app.service;

import java.util.ArrayList;
import java.util.List;

import com.pension.app.model.Pension;

import com.pension.app.repo.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PensionService
{
    @Autowired
    PensionRepository pensionRepository;


    public List<Pension> getAllData()
    {
        List<Pension> pensionList = new ArrayList<Pension>();
        pensionRepository.findAll().forEach(pensionList::add);
        return pensionList;
    }
    public Pension getById(int id) {

        return pensionRepository.findById(id).get();
    }
    public void saveEmp(Pension pension)
    {
        pensionRepository.save(pension);
    }

   // public Pension getBalance(int id) {
     //   return pensionRepository.findById(id).get();
    //}

}
