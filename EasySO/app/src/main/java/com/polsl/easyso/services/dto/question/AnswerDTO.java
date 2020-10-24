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

    private Boolean isUserSelect = false;
    private Status currentStatus = Status.NONE;

    public AnswerDTO(int id, String answerText, Boolean isCorrect) {
        this.id = id;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public AnswerDTO(AnswerDTO source)
    {
        this.id = source.getId();
        this.answerText =source.getAnswerText();
        this.isCorrect = source.getCorrect();
        this.isUserSelect = source.getIsUserSelect();
        this.currentStatus = source.getCurrentStatus();
    }

    public AnswerDTO() {
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Boolean getIsUserSelect() {
        return isUserSelect;
    }

    public void setIsUserSelect(Boolean isUserSelect) {
        this.isUserSelect = isUserSelect;
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

    public boolean isUserCheckCorrect(){
        return isUserSelect == isCorrect;
    }

    public enum Status{
        NONE,
        CORRECT,
        INCORRECT
    }
}
