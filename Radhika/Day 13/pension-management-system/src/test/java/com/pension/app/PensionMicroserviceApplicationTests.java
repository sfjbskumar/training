package com.pension.app;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class PensionMicroserviceApplicationTests {

	@Autowired
	PensionService service;

	@Mock PensionRepository pensionRepo;

	@Test
void contextLoads(){
	Assertions.assertDoesNotThrow(this::doNotThrowException);
}
	private void doNotThrowException() {
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
}
