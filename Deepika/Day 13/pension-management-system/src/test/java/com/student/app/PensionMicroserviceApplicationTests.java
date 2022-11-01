package com.student.app;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PensionMicroserviceApplicationTests {
	@Autowired
	PensionService pensionService;
	//PensionController pensionController;
	@Mock
	PensionRepository pensionRepository;

	@Test
	void findAllTest() {
		Pension p = new Pension();
		p.setId(3);
		p.setPensinorName("Deepika");
		p.setPensinorAge(23);
		p.setBalance(40000);
		p.setPhoneNo(1920763812);
		p.setEmploymentStatus("A");
		p.setPensionStatus("N");
		p.setPensionmmyy("0422");
		p.setInstallment(2000);
		List<Pension> pensionList = new ArrayList<Pension>();
		pensionList.add(p);
		Mockito.when(pensionRepository.findAll()).thenReturn(pensionList);
	assertEquals(pensionList,pensionRepository.findAll()); }

	@Test
	void contextLoads() {
	}


	@Test
	void savePensionTest(){
		Pension pension = new Pension(1,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
		Mockito.when(pensionRepository.save(pension)).thenReturn(pension);
		assertEquals(pension,pensionService.saveOrUpdate(pension));
	}

	@Test
	void getPensionByIdTest(){
		Pension pension = new Pension(4,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
		Mockito.when(pensionRepository.findById(4)).thenReturn(Optional.of(pension));
		assertEquals(pensionRepository.findById(4),Optional.of(pension));
	}
//	@Test
//	void deletePensionByIdTest(){
//		Pension pension = new Pension(4,"Deepika",23,10000,1619736254,"R","Y","0422",1000);
//		pensionService.delete(pension.getId());
//		verify(pensionRepository,times(1)).deleteById(4);
//	}


}
