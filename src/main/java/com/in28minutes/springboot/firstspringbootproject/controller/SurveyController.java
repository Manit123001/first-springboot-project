package com.in28minutes.springboot.firstspringbootproject.controller;

import com.in28minutes.springboot.firstspringbootproject.model.Question;
import com.in28minutes.springboot.firstspringbootproject.model.Survey;
import com.in28minutes.springboot.firstspringbootproject.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Void> addQuestionToSurvey(@PathVariable String surveyId,
                                                    @RequestBody Question newQuestion) {
        /*{
            "id": "Question1",
                "description": "Largest Country in the World",
                "correctAnswer": "Russia",
                "options": [
                    "India",
                    "Russia",
                    "United States",
                    "China"
            ]
        }*/

        Question question = surveyService.addQuestion(surveyId, newQuestion);

        if (question == null)
            return ResponseEntity.noContent().build();

        // Success - URI of the new resource in Response Header
        // Status - created
        // URI -> /surveys/{surveyId}/questions/{questionId}
        // question.getQuestionId()

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(question.getId()).toUri();
        System.out.println(location.toString());

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveQuestion(@PathVariable String surveyId,
                                     @PathVariable String questionId) {

        return surveyService.retrieveQuestion(surveyId, questionId);
    }

}

