package com.pension.app;

import com.pension.app.Pension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;


@SpringBootTest
class PensionMicroserviceApplicationTests {

	@Autowired
	PensionService service;

	@Mock private PensionRepository pensionRepo;

	@Test
	void contextLoads() {
	}
	@Test
	public void getAllPensionTest(){
		when(pensionRepo.findAll()).thenReturn(Stream.of(new Pension(1,22,"Sushil S",10000,334545,"R","Y","4-2022",1000), new Pension(2,22,"Sushil S",10000,334545,"R","Y","4-2022",1000)).collect(Collectors.toList()));
		assertEquals(8,service.getAllPension().size());
	}

	@Test
	public void findAllTest()
	{
		Pension p = new Pension();
		p.setId(1);
		p.setAge(22);
		p.setName("Harsh T");
		p.setBalance(100000);
		p.setEmpstatus("R");
		p.setPenstatus("N");
		p.setPenmmyy("07-2020");
		p.setInstallment(10000);
		List<Pension> pensionList = new ArrayList<Pension>();
		pensionList.add(p);
		when(pensionRepo.findAll()).thenReturn(pensionList);
		assertEquals(pensionList,pensionRepo.findAll());
	}

	@Test
	public void getPensionByIdTest(){
		int i = 1;
		Pension p = new Pension();
		p.setId(1);
		p.setAge(22);
		p.setName("Harsh T");
		p.setBalance(100000);
		p.setEmpstatus("R");
		p.setPenstatus("N");
		p.setPenmmyy("07-2020");
		p.setInstallment(10000);
		List<Pension> pensionList = new ArrayList<Pension>();
		pensionList.add(p);
		Pension p1 = pensionList.get(0);
		when(pensionRepo.findById(i)).thenReturn(p1);
//		List<Pension> list = new ArrayList<>();
//		list = service.getPensionById(i);
		assertEquals(p1,pensionRepo.findById(i));
	}



}





//(1,22,"Sushil S",10000,334545,"R","Y","4-2022",1000);
//(2,22,"Sushil S",10000,334545,"R","Y","4-2022",1000);