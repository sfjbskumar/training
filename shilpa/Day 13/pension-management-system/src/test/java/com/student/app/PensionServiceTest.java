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

public class PensionServiceTest {
    @Autowired
    private PensionService pensionService;
    @MockBean
    private PensionRepository pensionRepository;

   // @Test
    void testGetAllApplicants(){
        when(pensionRepository.findAll()).thenReturn(Stream
                .of(new Pension(201,"Shilpa",21,80000,998877,"A","N","0922",1000),new Pension(201,"Shilpa",21,80000,998877,"A","N","0922",1000)).collect(Collectors.toList()));
        assertEquals(2, pensionService.getAllApplicants().size());
    }

    //@Test
    void testGetApplicantById(){
        int id=201;
        Pension pension = new Pension();
        pension.setId(id);
        pension.setName("Shilpa");
        pension.setAge(21);
        pension.setBalance_amount(80000);
        pension.setPhone_no(9988776);
        pension.setEmp_status("A");
        pension.setPension_status("N");
        pension.setPension_mmyy("0922");
        pension.setInstallments(1000);
        Pension p = pension;
        when(pensionRepository.findById(id)).thenReturn(Optional.of(p));
        Pension pensioner = pensionService.getApplicantById(id);
        assertEquals(p.getId(), pensioner.getId());
        assertEquals(p.getName(), pensioner.getName());
        assertEquals(p.getAge(), pensioner.getAge());
        assertEquals(p.getBalance_amount(), pensioner.getBalance_amount());
        assertEquals(p.getPhone_no(), pensioner.getPhone_no());
        assertEquals(p.getPension_status(), pensioner.getPension_status());
        assertEquals(p.getPension_mmyy(), pensioner.getPension_mmyy());
        assertEquals(p.getInstallments(), pensioner.getInstallments());

    }

    //@Test
    void testCreateOrUpdate(){

        Pension p = new Pension();
        p.setId(201);
        p.setName("Shilpa");
        p.setAge(22);
        p.setBalance_amount(90000);
        p.setPhone_no(99887766);
        p.setEmp_status("A");
        p.setPension_status("N");
        p.setPension_mmyy("0922");
        p.setInstallments(980);
        pensionRepository.save(p);
        Assertions.assertThat(p.getId()).isPositive();
        verify(pensionRepository, times(1)).save(any(Pension.class));
    }

   // @Test
    void testDelete(){
        int id=201;
        Pension p = new Pension(201,"Sivani",21,80000,998877,"A","N","0922",1000);
        pensionService.delete(id);
        verify(pensionRepository, times(1)).deleteById(any());
    }



    //@Test
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
