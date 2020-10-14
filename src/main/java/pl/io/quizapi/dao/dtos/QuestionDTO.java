package pl.io.quizapi.dao.dtos;

import java.util.List;

public class QuestionDTO {
    private String question;
    private List<AnswerDTO> answers;

    public QuestionDTO() {
    }

    public QuestionDTO(String question, List<AnswerDTO> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
