package net.yorksolutions.pengmongthaocapstone1be.controllers;

import net.yorksolutions.pengmongthaocapstone1be.dto.AddSurveyResponsesDTO;
import net.yorksolutions.pengmongthaocapstone1be.models.SurveyResponses;
import net.yorksolutions.pengmongthaocapstone1be.services.SurveyResponsesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surveyresponses")
@CrossOrigin
public class SurveyResponsesController {
    SurveyResponsesService service;

    public SurveyResponsesController(SurveyResponsesService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<SurveyResponses> getAllSurveyResponses(){
        return this.service.getAllSurveyResponses();
    }

    @PostMapping
    public Iterable<SurveyResponses> addSurveyResponse(@RequestBody AddSurveyResponsesDTO request){
        return this.service.addSurveyResponse(request);
    }
}
