package com.pension.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.pension.app.Model.Pension;
import com.pension.app.Model.PensionBuilder;
import com.pension.app.Repository.PensionRepository;
import com.pension.app.Service.PensionService;
import org.assertj.core.api.Assertions;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PensionServiceTest{

    @Autowired
    private PensionService pensionService;
    @MockBean
    private PensionRepository pensionRepository;

    @Test
    void testGetAllApplicants(){
        when(pensionRepository.findAll()).thenReturn(Stream
                .of(new Pension(1,"hari",22,1860,"9988776655","R","Y","0922",10), new Pension(2,"harini",20,2000,"1234","A","N","1110",10)).collect(Collectors.toList()));

        assertEquals(2, pensionService.getAllApplicants().size());
    }

    @Test
    void testGetApplicantById(){
        int id=1;
        PensionBuilder pensionBuilder = new PensionBuilder();
        pensionBuilder.setId(id);
        pensionBuilder.setName("hari");
        pensionBuilder.setAge(22);
        pensionBuilder.setBalance(1860);
        pensionBuilder.setMobile("9988776655");
        pensionBuilder.setEmpStatus("R");
        pensionBuilder.setPensionStatus("Y");
        pensionBuilder.setPensionMMYY("0922");
        pensionBuilder.setInstallment(10);
        Pension p = pensionBuilder.createPension();
        when(pensionRepository.findById(id)).thenReturn(Optional.of(p));
        Pension pensioner = pensionService.getApplicantById(id);
        assertEquals(p.getId(), pensioner.getId());
        assertEquals(p.getName(), pensioner.getName());
        assertEquals(p.getAge(), pensioner.getAge());
        assertEquals(p.getBalance(), pensioner.getBalance());
        assertEquals(p.getMobile(), pensioner.getMobile());
        assertEquals(p.getEmpStatus(), pensioner.getEmpStatus());
        assertEquals(p.getPensionStatus(), pensioner.getPensionStatus());
        assertEquals(p.getPensionMMYY(), pensioner.getPensionMMYY());
        assertEquals(p.getInstallment(), pensioner.getInstallment());

    }

    @Test
    void testCreateOrUpdate(){

        Pension pensionBuilder = new PensionBuilder().createPension();
        pensionBuilder.setId(1);
        pensionBuilder.setName("hari");
        pensionBuilder.setAge(22);
        pensionBuilder.setBalance(1860);
        pensionBuilder.setMobile("9988776655");
        pensionBuilder.setEmpStatus("R");
        pensionBuilder.setPensionStatus("Y");
        pensionBuilder.setPensionMMYY("0922");
        pensionBuilder.setInstallment(10);
        pensionRepository.save(pensionBuilder);
        Assertions.assertThat(pensionBuilder.getId()).isPositive();
        verify(pensionRepository, times(1)).save(any(Pension.class));
    }

    @Test
    void testDelete(){
        int id=201;
        Pension p = new Pension(1,"hari",22,1860,"9988776655","R","Y","0922",10);
        pensionService.delete(id);
        verify(pensionRepository, times(1)).deleteById(any());
    }

   @Test
    void testGetStatus(){
        int id=201;
        Pension p = new Pension(1,"hari",22,1860,"9988776655","R","Y","0922",10);
        when(pensionRepository.getEmpStatus(id)).thenReturn("R");
        assertEquals("R",pensionRepository.getEmpStatus(id));
       when(pensionRepository.getPensionStatus(id)).thenReturn("Y");
       assertEquals("Y",pensionRepository.getPensionStatus(id));
    }

    @Test
    void testGetBalanceDetails(){
        int id=201;
        Pension p = new Pension(1,"hari",22,1860,"9988776655","R","Y","0922",10);
        when(pensionRepository.getBalance(id)).thenReturn("1860");
        assertEquals("1860",pensionRepository.getBalance(id));
        when(pensionRepository.getInstallment(id)).thenReturn("10");
        assertEquals("10",pensionRepository.getInstallment(id));
        when(pensionRepository.getPensionMMYY(id)).thenReturn("0922");
        assertEquals("0922",pensionRepository.getPensionMMYY(id));

    }

    @Test
    void testLoadPension(){
        pensionService.loadPension();
        verify(pensionRepository).loadPension(any(),any(),any(),any());
    }

    @Test
    void testIssuePension(){
        pensionService.issuePension();
        verify(pensionRepository).issuePension(any(),any(),any(),any());
    }
}