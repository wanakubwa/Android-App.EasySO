package pl.io.quizapi.dao.dtos;


import java.util.List;

public class QuizDTO {
    private String name;
    private List<QuestionDTO> questions;

    public QuizDTO() {
    }

    public QuizDTO(String name, List<QuestionDTO> questions) {
        this.name = name;
        this.questions = questions;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
