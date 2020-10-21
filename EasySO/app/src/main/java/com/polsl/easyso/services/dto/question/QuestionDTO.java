package com.polsl.easyso.services.dto.question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionDTO {

    @Expose
    @SerializedName("uid")
    private int id;

    @Expose
    @SerializedName("question")
    private String questionText;

    @Expose
    @SerializedName("answers")
    private List<AnswerDTO> answers;

    public QuestionDTO(int id, String questionText, List<AnswerDTO> answers) {
        this.id = id;
        this.questionText = questionText;
        this.answers = answers;
    }

    public QuestionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
