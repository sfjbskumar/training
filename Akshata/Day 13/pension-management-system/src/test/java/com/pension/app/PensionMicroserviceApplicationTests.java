package com.pension.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class PensionMicroserviceApplicationTests {

    @Autowired
    PensionService pService;
    PensionController pController;

    @Mock
    private PensionRepository pRepo;


    @Test
    public void contextLoads() {

    }

    @Test
    public void getAllPensionTest(){
        when(pRepo.findAll()).thenReturn(Stream.of(new Pension(101,"Akshata","22",8323947,10000,"R","Y","12112000",120),new Pension(112,"Anita","22",5687654,12000,"R","Y","21022022",120)).collect(Collectors.toList()));
        assertEquals(3,pService.getAllPension().size());
    }

    @Test
    public void findAllTest()
    {
        Pension p= new Pension();
        p.setId(107);
        p.setName("Amulya");
        p.setAge("26");
        p.setBalamt(2400);
        p.setEstatus("R");
        p.setPstatus("Y");
        p.setPmonth("22112000");
        p.setInstallment(355);
        List<Pension> pensionList=new ArrayList<Pension>();
        pensionList.add(p);
        Pension p1 = pensionList.get(0);
        when(pRepo.findAll()).thenReturn(pensionList);
        assertEquals(pensionList,pRepo.findAll());
    }


}