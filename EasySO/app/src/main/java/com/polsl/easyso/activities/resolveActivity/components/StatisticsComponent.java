package com.polsl.easyso.activities.resolveActivity.components;

import com.polsl.easyso.constants.Constants;

import java.io.Serializable;

public class StatisticsComponent implements Serializable {

    private int sumOfAnswers = 0;
    private int sumOfCorrectAnswers = 0;
    private int sumOfQuestions = 0;

    public int getSumOfAnswers() {
        return sumOfAnswers;
    }

    public int getSumOfCorrectAnswers() {
        return sumOfCorrectAnswers;
    }

    public int getSumOfQuestions() {
        return sumOfQuestions;
    }

    public int getScore(){
        return sumOfCorrectAnswers * Constants.SCORE_MULTIPLIER;
    }

    public void increaseCorrectAnswer(){
        sumOfAnswers++;
        sumOfCorrectAnswers++;
    }

    public void increaseInCorrectAnswers(){
        sumOfAnswers++;
    }

    public void reset(){
        sumOfCorrectAnswers = 0;
        sumOfAnswers = 0;
        sumOfQuestions=0;
    }

    public void increaseQuestions(){
        sumOfQuestions++;
    }
}
