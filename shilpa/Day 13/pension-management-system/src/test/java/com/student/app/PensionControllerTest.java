package com.student.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PensionController.class)
public class PensionControllerTest {
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
            p.setId(201);
            p.setName("Shilpa");
            p.setAge(22);
            p.setBalance_amount(90000);
            p.setPhone_no(99887766);
            p.setEmp_status("A");
            p.setPension_status("N");
            p.setPension_mmyy("0922");
            p.setInstallments(980);

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
            p.setId(201);
            p.setName("Shilpa");
            p.setAge(22);
            p.setBalance_amount(90000);
            p.setPhone_no(998877);
            p.setEmp_status("A");
            p.setPension_status("N");
            p.setPension_mmyy("0922");
            p.setInstallments(980);

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

        //@Test
        void testGetApplicant() throws Exception{
            Pension p = new Pension();
            p.setId(201);
            p.setName("Shilpa");
            p.setAge(22);
            p.setBalance_amount(90000);
            p.setPhone_no(9988776);
            p.setEmp_status("A");
            p.setPension_status("N");
            p.setPension_mmyy("0922");
            p.setInstallments(980);

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
            p.setId(201);
            p.setName("Shilpa");
            p.setAge(22);
            p.setBalance_amount(90000);
            p.setPhone_no(99887);
            p.setEmp_status("A");
            p.setPension_status("N");
            p.setPension_mmyy("0922");
            p.setInstallments(980);

            Pension p2 = new Pension();
            p2.setId(202);
            p2.setName("Seelu");
            p2.setAge(62);
            p2.setBalance_amount(93000);
            p2.setPhone_no(8888776);
            p2.setEmp_status("R");
            p2.setPension_status("Y");
            p2.setPension_mmyy("0922");
            p2.setInstallments(990);

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
            p.setId(201);
            p.setName("Shilpa");
            p.setAge(22);
            p.setBalance_amount(90000);
            p.setPhone_no(998877);
            p.setEmp_status("A");
            p.setPension_status("N");
            p.setPension_mmyy("0922");
            p.setInstallments(980);

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
