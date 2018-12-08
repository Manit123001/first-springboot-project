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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/Survey1/questions/Question1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mockResult = mockMvc.perform(requestBuilder).andReturn();

        // Assert
        JSONAssert.assertEquals(
                "{\"id\":\"Question1\", \"description\":\"Largest Country in the World\"}",
                mockResult.getResponse().getContentAsString(), false);
    }

    @Test
    public void createSurveyQuestion() throws Exception {

        // Mock Data
        Question mockQuestion = new Question("1",
                "Smallest Number",
                "1",
                Arrays.asList("1", "2", "3", "4"));
        Mockito.when(surveyService.addQuestion(Mockito.anyString(), Mockito.any(Question.class))).thenReturn(mockQuestion);

        // Make a call service
        String questionJsonBody = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/surveys/Survey1/questions")
                .accept(MediaType.APPLICATION_JSON)
                .content(questionJsonBody)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        // Assert
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals("http://localhost/surveys/Survey1/questions/1", response.getHeader(HttpHeaders.LOCATION));
    }

    @Test
    public void retrieveSurveyQuestions() throws Exception {
        // Mock data
        List<Question> mockListQuestions = Arrays.asList(
                new Question("Question1", "A", "B", Arrays.asList("11", "22", "33", "44")),
                new Question("Question2", "A", "B", Arrays.asList("11", "22", "33", "44"))
        );
        Mockito.when(surveyService.retrieveQuestions(eq("Survey1"))).thenReturn(mockListQuestions);

        // Make a call service
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/Survey1/questions").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String expected = "[{" +
                "   \"id\":\"Question1\"," +
                "   \"description\":\"A\"," +
                "   \"correctAnswer\":\"B\"," +
                "   \"options\":[\"11\",\"22\",\"33\",\"44\"]" +
                "}," +
                "{  " +
                "   \"id\":\"Question2\"," +
                "   \"description\":\"A\"," +
                "   \"correctAnswer\":\"B\"," +
                "   \"options\":[\"11\",\"22\",\"33\",\"44\"]" +
                "}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}