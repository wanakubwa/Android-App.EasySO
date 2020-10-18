package com.polsl.easyso.services.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionTopicDTO {

    @Expose
    @SerializedName("name")
    private String label;

    @Expose
    @SerializedName("numberOfQuestions")
    private Integer questionsCount;

    public QuestionTopicDTO(String label, Integer questionsCount) {
        this.label = label;
        this.questionsCount = questionsCount;
    }

    public QuestionTopicDTO() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(Integer questionsCount) {
        this.questionsCount = questionsCount;
    }
}
