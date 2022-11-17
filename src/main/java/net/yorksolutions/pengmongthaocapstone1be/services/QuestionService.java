package net.yorksolutions.pengmongthaocapstone1be.services;

import net.yorksolutions.pengmongthaocapstone1be.models.Question;
import net.yorksolutions.pengmongthaocapstone1be.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public Question updateQuestion(Question updatedQuestion) {
        this.repo.save(updatedQuestion);
        return updatedQuestion;
    }

    public Question deleteQuestion(Question question) {
        this.repo.delete(question);
        return question;
    }
}
