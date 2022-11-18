package net.yorksolutions.pengmongthaocapstone1be.services;

import net.yorksolutions.pengmongthaocapstone1be.dto.AddQuestionDTO;
import net.yorksolutions.pengmongthaocapstone1be.dto.AddSurveyDTO;
import net.yorksolutions.pengmongthaocapstone1be.models.Question;
import net.yorksolutions.pengmongthaocapstone1be.models.Survey;
import net.yorksolutions.pengmongthaocapstone1be.models.SurveyResponses;
import net.yorksolutions.pengmongthaocapstone1be.repositories.QuestionRepository;
import net.yorksolutions.pengmongthaocapstone1be.repositories.SurveyRepository;
import net.yorksolutions.pengmongthaocapstone1be.repositories.SurveyResponsesRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SurveyService {

    SurveyRepository repo;
    QuestionRepository questionRepo;
    SurveyResponsesRepository surveyResponseRepo;

    public SurveyService(SurveyRepository repo, QuestionRepository questionRepo,SurveyResponsesRepository surveyResponseRepo) {
        this.repo = repo;
        this.questionRepo = questionRepo;
        this.surveyResponseRepo = surveyResponseRepo;
    }

    public Iterable<Survey> getAllSurveys() {
        return this.repo.findAll();
    }

    public Iterable<Survey> addSurvey(AddSurveyDTO request) {
        Survey newSurvey = new Survey(request.getTitle());
        List<AddQuestionDTO> questionList = request.getQuestionList();
        for(int i = 0; i < questionList.size(); i++){
            Question newQuestion = new Question(questionList.get(i).getQuestion(),questionList.get(i).getQuestionOrder(),
                    questionList.get(i).getType(),questionList.get(i).getChoices());
            this.questionRepo.save(newQuestion);
            newSurvey.getQuestionSet().add(newQuestion);
        }
        this.repo.save(newSurvey);
        return this.repo.findAll();
    }

    public Iterable<Survey> deleteSurvey(Survey survey) {
        Iterable<SurveyResponses> surveyResponses = this.surveyResponseRepo.findAllBySurveyId(survey.getId());
        for(SurveyResponses response: surveyResponses){
            this.surveyResponseRepo.delete(response);
        }
        this.repo.delete(survey);
        return this.repo.findAll();
    }

    public Iterable<Survey> updateSurvey(AddSurveyDTO request, Long id) {
        Survey newSurvey = new Survey(request.getTitle());
        newSurvey.setId(id);

        // Get rid of old questions in DB
        Survey oldSurvey = this.repo.findById(id).orElseThrow();
        List<Long> oldQuestionList = new ArrayList<Long>();
        for(Question question: oldSurvey.getQuestionSet()){
            oldQuestionList.add(question.getId());
        }

        List<AddQuestionDTO> questionList = request.getQuestionList();
        for(int i = 0; i < questionList.size(); i++){
            Question newQuestion = new Question(questionList.get(i).getQuestion(),questionList.get(i).getQuestionOrder(),
                    questionList.get(i).getType(),questionList.get(i).getChoices());

            // use old ID's, so we don't create new rows everytime we update
            if(i < oldSurvey.getQuestionSet().size()){
                newQuestion.setId(oldQuestionList.get(i));
            }
            this.questionRepo.save(newQuestion);
            newSurvey.getQuestionSet().add(newQuestion);
        }
        this.repo.save(newSurvey);
        return this.repo.findAll();
    }
}
