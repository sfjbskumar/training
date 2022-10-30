package com.pension.app;


import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class PensionMicroserviceApplicationTests {

	@Autowired
	PensionService service;

	@Mock PensionRepository pensionRepo;


	@Test
	void contextLoads() {
	}
	@Test
	 void getAllPensionTest(){
		when(pensionRepo.findAll()).thenReturn(Stream.of(new Pension(1,22,"Sushil S",10000,334545,"R","Y","4-2022",1000), new Pension(2,22,"Sushil S",10000,334545,"R","Y","4-2022",1000)).collect(Collectors.toList()));
		assertEquals(7,service.getAllPension().size());
	}

	@Test
	void findAllTest()
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

//	@Test
//	public void getPensionByIdTest(){
//		Pension pension = new Pension(1,22,"Sushil S",10000,334545,"R","Y","4-2022",1000);
//		when(pensionRepo.findById(1)).thenReturn(Optional.of(pension));
//		assertEquals(pension,service.getPensionById(pension.getId()));
//	}


//	@Test
//	public void getPensionByIdTest(){
//		Pension p = new Pension();
//		p.setId(2);
//		p.setAge(22);
//		p.setName("Harsh T");
//		p.setBalance(100000);
//		p.setEmpstatus("R");
//		p.setPenstatus("N");
//		p.setPenmmyy("07-2020");
//		p.setInstallment(10000);
//		when(pensionRepo.findById(p.getId())).thenReturn(Optional.of(p));
//		assertEquals(p,service.getPensionById(p.getId()));
//	}



//	@Test
//	public void deleteTest(){
//		Pension pension = new Pension(1,22,"Sushil S",10000,334545,"R","Y","4-2022",1000);
//		int i = pension.getId();
//		service.delete(i);
//		verify(pensionRepo,times(1)).deleteById(i);
//	}

}
