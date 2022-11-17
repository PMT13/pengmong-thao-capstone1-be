package net.yorksolutions.pengmongthaocapstone1be.models;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String question;
    private int questionOrder;

    private String type;

    private String choices;

    public Question(String question, int questionOrder, String type, String choices) {
        this.question = question;
        this.questionOrder = questionOrder;
        this.type = type;
        this.choices = choices;
    }

    public Question() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int order) {
        this.questionOrder = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
