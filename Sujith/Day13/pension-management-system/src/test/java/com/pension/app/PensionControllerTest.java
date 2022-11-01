package com.pension.app;

import com.pension.app.Pension;
import com.pension.app.PensionController;
import com.pension.app.PensionRepository;
import com.pension.app.PensionService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.assertj.core.api.Assertions;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@WebMvcTest(PensionController.class)
@RunWith(SpringRunner.class)
class PensionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PensionService pensionService;

    @MockBean
    private PensionRepository pensionRepository;

    @Test
    @WithMockUser(roles = "ADMIN")
    void testSavePension() throws Exception{
        Pension p = new Pension();
        p.setId(101);
        p.setName("Kumar");
        p.setAge(22);
        p.setBalance(90000);
        p.setPhoneNo(123456);
        p.setEmpStatus("A");
        p.setPenApproval("N");
        p.setPenMmYy("09/21");
        p.setInstallment(980);

        String inputInJson = this.mapToJson(p);

        String URI = "/createPension";

        Mockito.when(pensionService.saveOrUpdate(Mockito.any(Pension.class))).thenReturn(p);
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
    void testEditPension() throws Exception{
        Pension p = new Pension();
        p.setId(101);
        p.setName("Kumar");
        p.setAge(22);
        p.setBalance(90000);
        p.setPhoneNo(123456);
        p.setEmpStatus("A");
        p.setPenApproval("N");
        p.setPenMmYy("09/21");
        p.setInstallment(980);

        String inputInJson = this.mapToJson(p);

        String URI = "/editPension";

        Mockito.when(pensionService.saveOrUpdate(Mockito.any(Pension.class))).thenReturn(p);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    @WithMockUser(roles = "USER")
    void testGetPensionApp() throws Exception{
        Pension p = new Pension();
        p.setId(101);
        p.setName("Kumar");
        p.setAge(22);
        p.setBalance(90000);
        p.setPhoneNo(123456);
        p.setEmpStatus("A");
        p.setPenApproval("N");
        p.setPenMmYy("09/21");
        p.setInstallment(980);

        String URI = "/checkApplication/101";

        Mockito.when(pensionService.getPensionById(Mockito.anyInt())).thenReturn(p);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(p);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testGetAllPension() throws Exception{
        Pension p = new Pension();
        p.setId(101);
        p.setName("Kumar");
        p.setAge(22);
        p.setBalance(90000);
        p.setPhoneNo(123456);
        p.setEmpStatus("A");
        p.setPenApproval("N");
        p.setPenMmYy("09/21");
        p.setInstallment(980);

        Pension p2 = new Pension();
        p2.setId(102);
        p2.setName("Raman");
        p2.setAge(24);
        p2.setBalance(93000);
        p2.setPhoneNo(456789);
        p2.setEmpStatus("R");
        p2.setPenApproval("Y");
        p2.setPenMmYy("09/19");
        p2.setInstallment(990);

        List<Pension> pList = new ArrayList<>();
        pList.add(p);
        pList.add(p2);

        Mockito.when(pensionService.getAllPension()).thenReturn(pList);

        String URI = "/get/allPension";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(pList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);

    }

    @Test
    void deletePension() throws Exception {
        Pension p = new Pension();
        p.setId(101);
        p.setName("Kumar");
        p.setAge(22);
        p.setBalance(90000);
        p.setPhoneNo(123456);
        p.setEmpStatus("A");
        p.setPenApproval("N");
        p.setPenMmYy("09/20");
        p.setInstallment(980);

        String URI = "/deletePension/101";

        Mockito.when(pensionService.delete(101)).thenReturn("Delete Success.");


        mockMvc.perform(MockMvcRequestBuilders.delete("/deletePension/201"))
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



