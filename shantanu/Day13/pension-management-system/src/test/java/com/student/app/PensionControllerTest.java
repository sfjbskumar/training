package com.student.app;

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
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
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
        p.setId(99);
        p.setName("shantanu");
        p.setAge(22);
        p.setBalance(80000);
        p.setMobile("9564871314");
        p.setEmpStatus("A");
        p.setPensionStatus("N");
        p.setPensionMMYY("0722");
        p.setInstallment(880);

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
        p.setId(99);
        p.setName("shantanu");
        p.setAge(22);
        p.setBalance(80000);
        p.setMobile("9564871314");
        p.setEmpStatus("A");
        p.setPensionStatus("N");
        p.setPensionMMYY("0722");
        p.setInstallment(880);

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
        p.setId(99);
        p.setName("shantanu");
        p.setAge(22);
        p.setBalance(80000);
        p.setMobile("9564871314");
        p.setEmpStatus("A");
        p.setPensionStatus("N");
        p.setPensionMMYY("0722");
        p.setInstallment(880);

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
        p.setId(99);
        p.setName("shantanu");
        p.setAge(22);
        p.setBalance(80000);
        p.setMobile("9564871314");
        p.setEmpStatus("A");
        p.setPensionStatus("N");
        p.setPensionMMYY("0722");
        p.setInstallment(880);

        Pension p2 = new Pension();
        p.setId(99);
        p.setName("shantanu");
        p.setAge(22);
        p.setBalance(80000);
        p.setMobile("9564871314");
        p.setEmpStatus("A");
        p.setPensionStatus("N");
        p.setPensionMMYY("0722");
        p.setInstallment(880);

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
        p.setId(99);
        p.setName("shantanu");
        p.setAge(22);
        p.setBalance(80000);
        p.setMobile("9564871314");
        p.setEmpStatus("A");
        p.setPensionStatus("N");
        p.setPensionMMYY("0722");
        p.setInstallment(880);

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
