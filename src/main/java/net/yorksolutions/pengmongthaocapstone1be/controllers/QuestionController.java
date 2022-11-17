package net.yorksolutions.pengmongthaocapstone1be.controllers;

import net.yorksolutions.pengmongthaocapstone1be.models.Question;
import net.yorksolutions.pengmongthaocapstone1be.services.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@CrossOrigin
public class QuestionController {

    QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @PutMapping
    public Question updateQuestion(@RequestBody Question updatedQuestion){
        return this.service.updateQuestion(updatedQuestion);
    }

    @DeleteMapping
    public Question deleteQuestion(@RequestBody Question question){
        return this.service.deleteQuestion(question);
    }
}
