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
	public void findAllTest()
	{
		Pension p = new Pension();
		p.setId(1);
		p.setAge(21);
		p.setName("Sagar");
		p.setBal(100000);
		p.setEmpStatus("R");
		p.setPenStatus("N");
		p.setLastPension("07/2022");
		p.setInstallment(11000);
		List<Pension> pensionList = new ArrayList<Pension>();
		pensionList.add(p);
		when(pensionRepo.findAll()).thenReturn(pensionList);
		assertEquals(pensionList,pensionRepo.findAll());
	}

}





