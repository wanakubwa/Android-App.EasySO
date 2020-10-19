package pl.io.quizapi.dao.dtos;

public class CategoryDTO {
    private String name;
    private Integer numberOfQuizzes;

    public CategoryDTO() {

    }

    public CategoryDTO(String name, Integer numberOfQuizzes) {
        this.name = name;
        this.numberOfQuizzes = numberOfQuizzes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfQuizzes() {
        return numberOfQuizzes;
    }

    public void setNumberOfQuizzes(Integer numberOfQuizzes) {
        this.numberOfQuizzes = numberOfQuizzes;
    }
}
