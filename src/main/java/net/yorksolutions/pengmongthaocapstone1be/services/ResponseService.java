package net.yorksolutions.pengmongthaocapstone1be.services;

import net.yorksolutions.pengmongthaocapstone1be.dto.AddResponseDTO;
import net.yorksolutions.pengmongthaocapstone1be.models.Response;
import net.yorksolutions.pengmongthaocapstone1be.models.SurveyResponses;
import net.yorksolutions.pengmongthaocapstone1be.repositories.ResponseRepository;
import net.yorksolutions.pengmongthaocapstone1be.repositories.SurveyResponsesRepository;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    ResponseRepository repo;
    SurveyResponsesRepository surveyResponsesRepository;

    public ResponseService(ResponseRepository repo,SurveyResponsesRepository surveyResponsesRepository) {
        this.repo = repo;
        this.surveyResponsesRepository = surveyResponsesRepository;
    }

    public Iterable<SurveyResponses> updateResponse(Response request) {
        this.repo.save(request);
        return this.surveyResponsesRepository.findAll();
    }

    public Iterable<SurveyResponses> addResponse(AddResponseDTO request, Long id) {
        Iterable<SurveyResponses> surveyResponses = this.surveyResponsesRepository.findAllBySurveyId(id);
        for(SurveyResponses response: surveyResponses){
            Response newResponse = new Response(request.getResponse(),request.getResponseOrder());
            this.repo.save(newResponse);
            response.getResponses().add(newResponse);
            this.surveyResponsesRepository.save(response);
        }
        return this.surveyResponsesRepository.findAll();
    }
}
