package com.in28minutes.springboot.firstspringbootproject.controller;

import com.in28minutes.springboot.firstspringbootproject.model.Question;
import com.in28minutes.springboot.firstspringbootproject.services.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.eq;


@RunWith(SpringRunner.class)
@WebMvcTest(value = SurveyController.class)
public class SurveyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Test
    public void retrieveDetailsForQuestion() throws Exception {

        // Mock Data
        Question mockQuestion = new Question("Question1",
                "Largest Country in the World",
                "Russia", Arrays.asList("India", "Russia", "United States", "China"));
        Mockito.when(surveyService.retrieveQuestion(Mockito.anyString(), eq("Question1"))).thenReturn(mockQuestion);

        // Make a call service
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/Survey1/questions/Question1").accept(MediaType.APPLICATION_JSON);
        MvcResult mockResult = mockMvc.perform(requestBuilder).andReturn();

        // Assert
        JSONAssert.assertEquals(
                "{\"id\":\"Question1\", \"description\":\"Largest Country in the World\"}",
                mockResult.getResponse().getContentAsString(), false);
    }
}