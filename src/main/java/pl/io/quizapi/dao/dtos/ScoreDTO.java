package pl.io.quizapi.dao.dtos;

public class ScoreDTO {

    private String username;

    private Integer score;

    public ScoreDTO(){

    }

    public ScoreDTO(String username, Integer score) {
        this.username = username;
        this.score = score;

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

}
