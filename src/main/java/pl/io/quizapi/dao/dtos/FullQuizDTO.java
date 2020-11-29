package pl.io.quizapi.dao.dtos;

public class FullQuizDTO {
    private String category;
    private QuizDTO quiz;

    public FullQuizDTO(){}

    public FullQuizDTO(String category, QuizDTO quiz) {
        this.category = category;
        this.quiz = quiz;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public QuizDTO getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizDTO quiz) {
        this.quiz = quiz;
    }
}
