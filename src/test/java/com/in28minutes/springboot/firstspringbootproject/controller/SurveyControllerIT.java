package com.in28minutes.springboot.firstspringbootproject.controller;

import com.in28minutes.springboot.firstspringbootproject.FirstSpringbootProjectApplication;
import com.in28minutes.springboot.firstspringbootproject.model.Question;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FirstSpringbootProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {
    @LocalServerPort
    private int port;

    @Test
    public void testJson() {
        try {
            JSONAssert.assertEquals("{id:1}", "{id:1,name:new}", false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRetrieveSurveyQuestion() {
        String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("response.getBody() = " + response.getBody());

        String expected = "{\"id\":\"Question1\", \"description\":\"Largest Country in the World\"}";

        try {
            JSONAssert.assertEquals(expected, response.getBody(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        String response = restTemplate.getForObject(url, String.class);
//        System.out.println("response = " + response);
//        assertTrue(response.contains("{\"id\":\"Question1\""));

//        response.getBody() = {"id":"Question1","description":"Largest Country in the World","correctAnswer":"Russia","options":["India","Russia","United States","China"]}
    }

    @Test
    public void addQuestion() {
        String url = "http://localhost:" + port + "/surveys/Survey1/questions";

        TestRestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Question question1 = new Question("AUTO Add",
                "Question add more",
                "Russia",
                Arrays.asList("India", "Russia", "United States", "China"));

        HttpEntity entity = new HttpEntity<Question>(question1, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        System.out.println("actual = " + actual); // http://localhost:65086/surveys/Survey1/questions/ksv8sa4i3aqd8rtsl9tv4b2h5l
        assertTrue(actual.contains("/surveys/Survey1/questions/"));
    }
}