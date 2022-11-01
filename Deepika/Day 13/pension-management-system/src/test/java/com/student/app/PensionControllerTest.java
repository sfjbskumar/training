package com.student.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PensionControllerTest {
    @Autowired
    PensionService pensionService;
    //PensionController pensionController;
    @Mock
    PensionRepository pensionRepository;
    //Pension pension=new Pension();

    @Test
    void savePensionTest() {
        Pension pension = new Pension(1,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
        Mockito.when(pensionRepository.save(pension)).thenReturn(pension);
        assertEquals(pension,pensionService.saveOrUpdate(pension));
    }

    @Test
    void getAllPensionTest() {
        Pension pension = new Pension(1,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
        Pension pension1 = new Pension(2,"nilam",46,10000,1619736254,"A","N","0422",1000);
      //  pensionRepository.save(pension1);
        //pensionRepository.save(pension);
        List<Pension> pensionList = new ArrayList<Pension>();
        pensionList.add(pension);
        pensionList.add(pension1);
        Mockito.when(pensionRepository.findAll()).thenReturn(pensionList);
        assertEquals(pensionList,pensionRepository.findAll());
    }

    @Test
    void getPensionByIdTest() {
        Pension pension = new Pension(4,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
        Mockito.when(pensionRepository.findById(4)).thenReturn(Optional.of(pension));
        assertEquals(pensionRepository.findById(4),Optional.of(pension));

    }

    @Test
    void getPensionBalanceByIdTest() {
        Pension pension = new Pension(4,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
        pensionService.saveOrUpdate(pension);
        Mockito.when(pensionRepository.findById(4)).thenReturn(Optional.of(pension));
        Pension p=pensionService.getPensionById(4);
        assertEquals(Optional.of(p.getBalance()),Optional.of(pension.getBalance()));

    }

    @Test
    void getPensionStatusByIdTest() {
        Pension pension = new Pension(4,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
        pensionService.saveOrUpdate(pension);
        Mockito.when(pensionRepository.findById(4)).thenReturn(Optional.of(pension));
        Pension p=pensionService.getPensionById(4);
        assertEquals(Optional.of(p.getPensionStatus()),Optional.of(pension.getPensionStatus()));
    }
    @Test
    void loadBalanceTest() {

    }

}