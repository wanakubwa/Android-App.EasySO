package com.polsl.easyso.services.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizCategoryDTO {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("numberOfQuizzes")
    private Integer quizezCount;

    public QuizCategoryDTO() {
    }

    public QuizCategoryDTO(String name, Integer quizezCount) {
        this.name = name;
        this.quizezCount = quizezCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuizezCount() {
        return quizezCount;
    }

    public void setQuizezCount(Integer quizezCount) {
        this.quizezCount = quizezCount;
    }
}
