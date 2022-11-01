package com.pension.app;

import com.pension.app.Controller.PensionController;
import com.pension.app.Model.Pension;
import com.pension.app.Repository.PensionRepository;
import com.pension.app.Service.PensionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PensionController.class)
 class PensionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PensionService pensionService;

    @MockBean
    private PensionRepository pensionRepository;

    @Test
    @WithMockUser(roles = "ADMIN")
     void testCreateApplicant() throws Exception{
        Pension p = new Pension();
        p.setId(1);
        p.setName("hari");
        p.setAge(22);
        p.setBalance(1860);
        p.setMobile("9988776655");
        p.setEmpStatus("R");
        p.setPensionStatus("Y");
        p.setPensionMMYY("0922");
        p.setInstallment(10);

        String inputInJson = this.mapToJson(p);

        String URI = "/create/applicant";

        Mockito.when(pensionService.createOrUpdate(Mockito.any(Pension.class))).thenReturn(p);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    @WithMockUser(roles = "ADMIN")
     void testEditApplicant() throws Exception{
        Pension p = new Pension();
        p.setId(1);
        p.setName("hari");
        p.setAge(22);
        p.setBalance(1860);
        p.setMobile("9988776655");
        p.setEmpStatus("R");
        p.setPensionStatus("Y");
        p.setPensionMMYY("0922");
        p.setInstallment(10);

        String inputInJson = this.mapToJson(p);

        String URI = "/edit/applicant";

        Mockito.when(pensionService.createOrUpdate(Mockito.any(Pension.class))).thenReturn(p);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
     void testGetApplicant() throws Exception{
        Pension p = new Pension();
        p.setId(1);
        p.setName("hari");
        p.setAge(22);
        p.setBalance(1860);
        p.setMobile("9988776655");
        p.setEmpStatus("R");
        p.setPensionStatus("Y");
        p.setPensionMMYY("0922");
        p.setInstallment(10);

        String URI = "/checkApplication/201";

        Mockito.when(pensionService.getApplicantById(Mockito.anyInt())).thenReturn(p);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(p);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    void testGetAllApplicants() throws Exception{
        Pension p = new Pension();
        p.setId(1);
        p.setName("hari");
        p.setAge(22);
        p.setBalance(1860);
        p.setMobile("9988776655");
        p.setEmpStatus("R");
        p.setPensionStatus("Y");
        p.setPensionMMYY("0922");
        p.setInstallment(10);

        Pension p2 = new Pension();
        p2.setId(2);
        p2.setName("harini");
        p2.setAge(20);
        p2.setBalance(2000);
        p2.setMobile("1234");
        p2.setEmpStatus("A");
        p2.setPensionStatus("N");
        p2.setPensionMMYY("1110");
        p2.setInstallment(10);

        List<Pension> pList = new ArrayList<>();
        pList.add(p);
        pList.add(p2);

        Mockito.when(pensionService.getAllApplicants()).thenReturn(pList);

        String URI = "/get/applicants";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(pList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);

    }

    @Test
    void deleteApplication() throws Exception {
        Pension p = new Pension();
        p.setId(1);
        p.setName("hari");
        p.setAge(22);
        p.setBalance(1860);
        p.setMobile("9988776655");
        p.setEmpStatus("R");
        p.setPensionStatus("Y");
        p.setPensionMMYY("0922");
        p.setInstallment(10);

        String URI = "/delete/applicant/201";

        Mockito.when(pensionService.delete(201)).thenReturn("Delete Success.");

        //Mockito.when(pensionService.delete(201)).thenReturn();
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/applicant/201"))
                .andExpect(status().isOk());
    }




    /**
     * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
     */
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}
