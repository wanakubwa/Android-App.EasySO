package pl.io.quizapi.dao.dtos;

public class QuizLabelDTO {
    private String name;
    private Integer numberOfQuestions;

    public QuizLabelDTO() {
    }

    public QuizLabelDTO(String name, Integer numberOfQuestions) {
        this.name = name;
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}
