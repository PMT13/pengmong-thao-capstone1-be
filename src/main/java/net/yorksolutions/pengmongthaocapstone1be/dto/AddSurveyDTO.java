package net.yorksolutions.pengmongthaocapstone1be.dto;

import java.util.List;

public class AddSurveyDTO {

    private String title;
    private List<AddQuestionDTO> questionList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AddQuestionDTO> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<AddQuestionDTO> questionList) {
        this.questionList = questionList;
    }
}
