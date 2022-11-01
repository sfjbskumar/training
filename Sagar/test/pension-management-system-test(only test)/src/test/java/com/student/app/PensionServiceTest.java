package com.student.app;

import static org.junit.Assert.*;
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

    @Test
    void testGetAllApplicants(){
        when(pensionRepository.findAll()).thenReturn(Stream
                .of(new PensionBuilder().setId(201).setName("Sivani").setAge(21).setBal(80000).setContact("9988776655").setEmpStatus("A").setPenStatus("N").setLastPension("0922").setInstallment(1000).createPension(),
                        new PensionBuilder().setId(202).setName("Srinu").setAge(60).setBal(90000).setContact("8899776655").setEmpStatus("R").setPenStatus("Y").setLastPension("0922").setInstallment(1200).createPension()).collect(Collectors.toList()));
        assertEquals(2, pensionService.getAllData().size());
    }

    @Test
    void testGetApplicantById(){
        int id=201;
        PensionBuilder pensionBuilder = new PensionBuilder();
        pensionBuilder.setId(id);
        pensionBuilder.setName("Sivani");
        pensionBuilder.setAge(21);
        pensionBuilder.setBal(80000);
        pensionBuilder.setContact("9988776655");
        pensionBuilder.setEmpStatus("A");
        pensionBuilder.setPenStatus("N");
        pensionBuilder.setLastPension("0922");
        pensionBuilder.setInstallment(1000);
        Pension p = pensionBuilder.createPension();
        when(pensionRepository.findById(id)).thenReturn(Optional.of(p));
        Pension pensioner = pensionService.getById(id);
        assertEquals(p.getId(), pensioner.getId());
        assertEquals(p.getName(), pensioner.getName());
        assertEquals(p.getAge(), pensioner.getAge());
        assertEquals(p.getBal(), pensioner.getBal());
        assertEquals(p.getContact(), pensioner.getContact());
        assertEquals(p.getEmpStatus(), pensioner.getEmpStatus());
        assertEquals(p.getPenStatus(), pensioner.getPenStatus());
        assertEquals(p.getLastPension(), pensioner.getLastPension());
        assertEquals(p.getInstallment(), pensioner.getInstallment());

    }

    @Test
    void testCreateOrUpdate(){

        Pension p = new PensionBuilder().createPension();
        p.setId(201);
                p.setName("Sivani");
                p.setAge(22);
                p.setBal(90000);
                p.setContact("9988776655");
                p.setEmpStatus("A");
                p.setPenStatus("N");
                p.setLastPension("0922");
                p.setInstallment(980);
        pensionRepository.save(p);
        Assertions.assertThat(p.getId()).isPositive();
        verify(pensionRepository, times(1)).save(any(Pension.class));
    }

    @Test
    void testDelete(){
        int id=201;
        Pension p = new PensionBuilder().setId(id).setName("Sivani").setAge(21).setBal(80000).setContact("9988776655").setEmpStatus("A").setPenStatus("N").setLastPension("0922").setInstallment(1000).createPension();
        pensionService.deleteEmp(id);
        verify(pensionRepository, times(1)).deleteById(any());
    }

   @Test
    void testGetStatus(){
        int id=201;
        Pension p = new PensionBuilder().setId(id).setName("Sivani").setAge(21).setBal(80000).setContact("9988776655").setEmpStatus("A").setPenStatus("N").setLastPension("0922").setInstallment(1000).createPension();
        when(pensionRepository.getEmpStatus(id)).thenReturn("A");
        assertEquals("A",pensionRepository.getEmpStatus(id));
       when(pensionRepository.getPenStatus(id)).thenReturn("N");
       assertEquals("N",pensionRepository.getPenStatus(id));
    }

    @Test
    void testGetBalanceDetails(){
        int id=201;
        Pension p = new PensionBuilder().setId(id).setName("Sivani").setAge(21).setBal(80000).setContact("9988776655").setEmpStatus("A").setPenStatus("N").setLastPension("0922").setInstallment(1000).createPension();
        when(pensionRepository.getBal(id)).thenReturn("80000");
        assertEquals("80000",pensionRepository.getBal(id));
        when(pensionRepository.getInstallment(id)).thenReturn("1000");
        assertEquals("1000",pensionRepository.getInstallment(id));
        when(pensionRepository.getLastPension(id)).thenReturn("0922");
        assertEquals("0922",pensionRepository.getLastPension(id));

    }

}