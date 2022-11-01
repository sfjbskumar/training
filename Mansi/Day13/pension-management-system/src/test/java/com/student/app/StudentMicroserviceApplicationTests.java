
package com.student.app;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(classes = PensionMicroserviceApplicationTests.class)
class PensionMicroserviceApplicationTests {



//	PensionService service;

	@Mock private PensionRepository pensionRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void findAllTest()
	{
		Pension p = new Pension();
		p.setId(1);
		p.setAge(22);
		p.setName("Harsh T");
		p.setBalance(100000);
		p.setEmpStatus("R");
		p.setPensionStatus("N");
		p.setPensionMMYY("07-2020");
		p.setInstallment(10000);
		List<Pension> pensionList = new ArrayList<>();
		pensionList.add(p);
		when(pensionRepo.findAll()).thenReturn(pensionList);
		assertEquals(pensionList,pensionRepo.findAll());
	}

	@Test
	void getPensionByIdTest(){
		int i = 1;
		Pension p = new Pension();
		p.setId(1);
		p.setAge(22);
		p.setName("Harsh T");
		p.setBalance(100000);
		p.setEmpStatus("R");
		p.setPensionStatus("N");
		p.setPensionMMYY("07-2020");
		p.setInstallment(10000);
		List<Pension> pensionList = new ArrayList<>();
		pensionList.add(p);
		Pension p1 = pensionList.get(0);
		when(pensionRepo.findById(i)).thenReturn(Optional.ofNullable(p1));

		assertEquals(Optional.ofNullable(p1),pensionRepo.findById(i));
	}



}

