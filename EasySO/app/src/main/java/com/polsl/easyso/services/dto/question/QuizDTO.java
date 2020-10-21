package com.polsl.easyso.services.dto.question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizDTO {

    @Expose
    @SerializedName("name")
    private String topicLabel;

    @Expose
    @SerializedName("questions")
    private List<QuestionDTO> questionsCollection;

    public QuizDTO() {
    }

    public QuizDTO(String topicLabel, List<QuestionDTO> questionsCollection) {
        this.topicLabel = topicLabel;
        this.questionsCollection = questionsCollection;
    }

    public String getTopicLabel() {
        return topicLabel;
    }

    public void setTopicLabel(String topicLabel) {
        this.topicLabel = topicLabel;
    }

    public List<QuestionDTO> getQuestionsCollection() {
        return questionsCollection;
    }

    public void setQuestionsCollection(List<QuestionDTO> questionsCollection) {
        this.questionsCollection = questionsCollection;
    }
}
