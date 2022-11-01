package com.student.app;

import java.util.ArrayList;
import java.util.List;

import com.sagar.demo.repository.StudentRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sagar.demo.model.Student;

@Service
public class PensionService
{
    public void saveOrUpadate(Pension pension) {
        pensionRepository.save(pension);
    }

    public List<Pension> getAllPension() {
        List<Pension> pensions = new ArrayList<Pension>();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        return pensions;
    }

    public Pension getPensionById(int id) {
        return pensionRepository.findById(id).get();
    }
}
