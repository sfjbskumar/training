package com.practice.miniproject;

import com.practice.miniproject.model.PensionModel;
import com.practice.miniproject.service.PensionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@SpringBootTest
public class PensionServiceTest {
    List<PensionModel> p = new ArrayList<PensionModel>();
    @Autowired
private PensionService pensionService;


@MockBean
private PensionRepository pensionRepository;

@Test
public void getAllApplicantsTest() {
    PensionModel p1 = new PensionModel(1, "Vani", 72, 8000, "7684925464", "R", "Y", "09/22", 1000);
    p.add(p1);
    PensionModel p2 = new PensionModel(3, "ravi", 89, 8000, "7684925400", "R", "N", "07/22", 1000);
    p.add(p2);

        when(pensionRepository.findAll()).thenReturn(Collections.singleton(p1));
                assertEquals(1, pensionService.getAllPension().size());
        }

@Test
public void getPensionByIDTest() {

        PensionModel p1 = new PensionModel(1, "Vani", 72, 8000, "7684925464", "R", "Y", "09/22", 1000);
        p.add(p1);
        PensionModel p2 = new PensionModel(3, "ravi", 89, 8000, "7684925400", "R", "N", "07/22", 1000);
        p.add(p2);


        when(pensionRepository.findById(1)).thenReturn(Optional.of(p1));
        assertEquals(1, pensionService.getPensionById(1).getId());
        }

@Test
public void deleteTest() {


        PensionModel p2 = new PensionModel(3, "ravi", 89, 8000, "7684925400", "R", "N", "07/22", 1000);


        doNothing().when(pensionRepository).delete(p2);
        }
        }
