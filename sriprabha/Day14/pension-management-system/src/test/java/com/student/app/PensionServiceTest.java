package com.student.app;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
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

    //@Test
    void testGetAllApplicants(){
        when(pensionRepository.findAll()).thenReturn(Stream
                .of(new PensionBuilder().setId(1).setName("Sri").setAge(20).setBalance(80000).setMobile("9988776655").setEmpStatus("A").setPensionStatus("N").setPensionMMYY("09-22").setInstallment(1000).createPension(),
                        new PensionBuilder().setId(2).setName("prabha").setAge(21).setBalance(90000).setMobile("8899776655").setEmpStatus("R").setPensionStatus("Y").setPensionMMYY("09-22").setInstallment(1200).createPension()).collect(Collectors.toList()));
        assertEquals(2, pensionService.getAllApplicants().size());
    }

   // @Test
    void testGetApplicantById(){
        int id=1;
        PensionBuilder pensionBuilder = new PensionBuilder();
        pensionBuilder.setId(id);
        pensionBuilder.setName("Sri");
        pensionBuilder.setAge(20);
        pensionBuilder.setBalance(80000);
        pensionBuilder.setMobile("9988776655");
        pensionBuilder.setEmpStatus("A");
        pensionBuilder.setPensionStatus("N");
        pensionBuilder.setPensionMMYY("09-22");
        pensionBuilder.setInstallment(1000);
        Pension p = pensionBuilder.createPension();
        when(pensionRepository.findById(id)).thenReturn(Optional.of(p));
        Pension pensioner = pensionService.getApplicantById(id);
        assertEquals(p.getId(), pensioner.getId());
        assertEquals(p.getName(), pensioner.getName());
        assertEquals(p.getAge(), pensioner.getAge());
        assertEquals(p.getBalance(), pensioner.getBalance());
        assertEquals(p.getPhone(), pensioner.getPhone());
        assertEquals(p.getEmpStatus(), pensioner.getEmpStatus());
        assertEquals(p.getPensionStatus(), pensioner.getPensionStatus());
        assertEquals(p.getPensionMMYY(), pensioner.getPensionMMYY());
        assertEquals(p.getInstallment(), pensioner.getInstallment());

    }

    //@Test
    void testCreateOrUpdate(){

        Pension p = new PensionBuilder().createPension();
        p.setId(1);
        p.setName("Sri");
        p.setAge(21);
        p.setBalance(10000);
        p.setPhone("9876543210");
        p.setEmpStatus("A");
        p.setPensionStatus("N");
        p.setPensionMMYY("09-22");
        p.setInstallment(1000);
        pensionRepository.save(p);
        Assertions.assertThat(p.getId()).isPositive();
        verify(pensionRepository, times(1)).save(any(Pension.class));
    }

   // @Test
    void testDelete(){
        int id=1;
        Pension p = new PensionBuilder().setId(id).setName("Sri").setAge(20).setBalance(80000).setMobile("9988776655").setEmpStatus("A").setPensionStatus("N").setPensionMMYY("09-22").setInstallment(1000).createPension();
        pensionService.delete(id);
        verify(pensionRepository, times(1)).deleteById(any());
    }

   //@Test
    void testGetStatus(){
        int id=1;
        Pension p = new PensionBuilder().setId(id).setName("Sri").setAge(20).setBalance(80000).setMobile("9988776655").setEmpStatus("A").setPensionStatus("N").setPensionMMYY("0922").setInstallment(1000).createPension();
        when(pensionRepository.getEmpStatus(id)).thenReturn("A");
        assertEquals("A",pensionRepository.getEmpStatus(id));
       when(pensionRepository.getPensionStatus(id)).thenReturn("N");
       assertEquals("N",pensionRepository.getPensionStatus(id));
    }

   // @Test
    void testGetBalanceDetails(){
        int id=1;
        Pension p = new PensionBuilder().setId(id).setName("Sri").setAge(20).setBalance(80000).setMobile("9988776655").setEmpStatus("A").setPensionStatus("N").setPensionMMYY("09-22").setInstallment(1000).createPension();
        when(pensionRepository.getBalance(id)).thenReturn("80000");
        assertEquals("80000",pensionRepository.getBalance(id));
        when(pensionRepository.getInstallment(id)).thenReturn("1000");
        assertEquals("1000",pensionRepository.getInstallment(id));
        when(pensionRepository.getPensionMMYY(id)).thenReturn("09-22");
        assertEquals("09-22",pensionRepository.getPensionMMYY(id));

    }

   // @Test
    void testLoadPension(){
        pensionService.loadPension();
        verify(pensionRepository).loadPension(any(),any(),any(),any());
    }

    //@Test
    void testIssuePension(){
        pensionService.issuePension();
        verify(pensionRepository).issuePension(any(),any(),any(),any());
    }
}