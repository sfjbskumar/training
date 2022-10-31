package com.pension.app;
import com.pension.app.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public void deleteEmp(int id)
    {

        pensionRepository.deleteById(id);
    }

}
