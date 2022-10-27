package com.pension.app;

//import com.pension.app.Repository.PensionRepository;
import com.pension.app.Service.PensionService;
import com.pension.app.model.Pension;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
//import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class PensionMicroserviceApplicationTests {
	@InjectMocks
	//Pension p = new Pension();
	@Mock
	PensionService pensionService;

	@Test
	public void testAdd() {
		Pension p = new Pension();
		p.setApplicant_id(p.getApplicant_id());
		List<Pension> pension_applicant = new ArrayList<Pension>();
		pension_applicant.add(p);
		when(PensionService.applicant_info()).thenReturn(pension_applicant);
		assertEquals(pension_applicant, PensionService.applicant_info());
	}





	@Test
	 void contextLoads() {
	}

}
