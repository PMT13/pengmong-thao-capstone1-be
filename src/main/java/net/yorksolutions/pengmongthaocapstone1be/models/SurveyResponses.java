package net.yorksolutions.pengmongthaocapstone1be.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SurveyResponses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public long surveyId;

    @OneToMany(orphanRemoval = true)
    private Set<Response> responses;

    public SurveyResponses(long surveyId) {
        this.surveyId = surveyId;
        this.responses = new HashSet<>();
    }

    public SurveyResponses() {

    }

    public long getQuestionId() {
        return surveyId;
    }

    public void setQuestionId(long questionId) {
        this.surveyId = questionId;
    }

    public Set<Response> getResponses() {
        return responses;
    }

    public void setResponses(Set<Response> responses) {
        this.responses = responses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
