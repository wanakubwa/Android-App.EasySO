package com.polsl.easyso.services.dto.question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public QuestionDTO(QuestionDTO source)
    {
        this.id = source.getId();
        this.questionText = source.getQuestionText();

        this.answers = new ArrayList<>();
        for(AnswerDTO answer : source.getAnswers())
        {
            this.answers.add(new AnswerDTO(answer));
        }
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

    public AnswerDTO getAnswerById(int answerId) {

        AnswerDTO output = null;

        for(AnswerDTO answer : answers){
            if(answer.getId() == answerId){
                output = answer;
                break;
            }
        }

        return output;
    }

    public void shuffleAnswers(){
        for(int i =0; i < 3; i++){
            shuffleList(answers);
        }
    }

    private void shuffleList(List<AnswerDTO> a) {
        int n = a.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private void swap(List<AnswerDTO> a, int i, int change) {
        AnswerDTO helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }
}
