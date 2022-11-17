package net.yorksolutions.pengmongthaocapstone1be.dto;
import java.util.List;

public class AddSurveyResponsesDTO {

    public long surveyId;

    private List<AddResponseDTO> responses;

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

    public List<AddResponseDTO> getResponses() {
        return responses;
    }

    public void setResponses(List<AddResponseDTO> responses) {
        this.responses = responses;
    }
}
