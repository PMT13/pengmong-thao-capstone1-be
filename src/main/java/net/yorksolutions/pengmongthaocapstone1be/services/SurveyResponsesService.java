package net.yorksolutions.pengmongthaocapstone1be.services;

import net.yorksolutions.pengmongthaocapstone1be.dto.AddResponseDTO;
import net.yorksolutions.pengmongthaocapstone1be.dto.AddSurveyResponsesDTO;
import net.yorksolutions.pengmongthaocapstone1be.models.Response;
import net.yorksolutions.pengmongthaocapstone1be.models.SurveyResponses;
import net.yorksolutions.pengmongthaocapstone1be.repositories.ResponseRepository;
import net.yorksolutions.pengmongthaocapstone1be.repositories.SurveyResponsesRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SurveyResponsesService {

    SurveyResponsesRepository repo;
    ResponseRepository responseRepo;

    public SurveyResponsesService(SurveyResponsesRepository repo,ResponseRepository responseRepo) {
        this.repo = repo;
        this.responseRepo = responseRepo;
    }

    public Iterable<SurveyResponses> getAllSurveyResponses() {
        return this.repo.findAll();
    }

    public Iterable<SurveyResponses> addSurveyResponse(AddSurveyResponsesDTO request) {
        SurveyResponses newSurveyResponses = new SurveyResponses(request.getSurveyId());
        List<AddResponseDTO> responseList = request.getResponses();
        for(int i = 0; i < responseList.size(); i++){
            Response newResponse = new Response(responseList.get(i).getResponse(),responseList.get(i).getResponseOrder());
            this.responseRepo.save(newResponse);
            newSurveyResponses.getResponses().add(newResponse);
        }
        this.repo.save(newSurveyResponses);
        return this.repo.findAll();
    }

    public Iterable<SurveyResponses> updateSurveyResponse(SurveyResponses request) {
        SurveyResponses newSurveyResponses = new SurveyResponses(request.surveyId);

        SurveyResponses oldSurveyResponses = this.repo.findById(request.getId()).orElseThrow();
        this.repo.delete(oldSurveyResponses);

        for(Response response: request.getResponses()){
            Response newResponse = new Response(response.getResponse(), response.getResponseOrder());
            this.responseRepo.save(newResponse);
            newSurveyResponses.getResponses().add(newResponse);
        }
        this.repo.save(newSurveyResponses);
        return this.repo.findAll();
    }
}
