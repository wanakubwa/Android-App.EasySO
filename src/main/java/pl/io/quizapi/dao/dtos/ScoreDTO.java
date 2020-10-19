package pl.io.quizapi.dao.dtos;

public class ScoreDTO {

    private String username;

    private Integer score;

    private String quizName;

    public ScoreDTO(){

    }

    public ScoreDTO(String username, Integer score, String quizName) {
        this.username = username;
        this.score = score;
        this.quizName = quizName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
}
