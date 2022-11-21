package net.yorksolutions.pengmongthaocapstone1be.controllers;

import net.yorksolutions.pengmongthaocapstone1be.dto.AddSurveyDTO;
import net.yorksolutions.pengmongthaocapstone1be.models.Survey;
import net.yorksolutions.pengmongthaocapstone1be.services.SurveyService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/survey")
@CrossOrigin
public class SurveyController {

    SurveyService service;

    public SurveyController(SurveyService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Survey> getAllSurveys(){
        return this.service.getAllSurveys();
    }

    @GetMapping("/{id}")
    public Optional<Survey> getSurveyById(@PathVariable Long id){
        return this.service.getSurveyById(id);
    }
    @PostMapping
    public Iterable<Survey> addSurvey(@RequestBody AddSurveyDTO request){
        return this.service.addSurvey(request);
    }

    @PutMapping("/{id}")
    public Iterable<Survey> updateSurvey(@RequestBody AddSurveyDTO request, @PathVariable Long id){
        return this.service.updateSurvey(request,id);
    }
    @PostMapping("/delete")
    public Iterable<Survey> deleteSurvey(@RequestBody Survey survey){
        return this.service.deleteSurvey(survey);
    }
}
