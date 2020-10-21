package com.polsl.easyso.services.dto.question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerDTO {

    @Expose
    @SerializedName("uid")
    private int id;

    @Expose
    @SerializedName("answer")
    private String answerText;

    @Expose
    @SerializedName("result")
    private Boolean isCorrect;

    public AnswerDTO(int id, String answerText, Boolean isCorrect) {
        this.id = id;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public AnswerDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
