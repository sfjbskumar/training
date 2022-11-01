package com.student.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("pensionService")
@Transactional
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

    public void deleteEmp(int id)
    {

        pensionRepository.deleteById(id);
    }
}
