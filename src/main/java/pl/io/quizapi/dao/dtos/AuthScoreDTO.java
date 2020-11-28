package pl.io.quizapi.dao.dtos;

public class AuthScoreDTO {

    private String username;

    private Integer score;

    private String authKey;


    public AuthScoreDTO() {
    }

    public AuthScoreDTO(String username, Integer score, String authKey) {
        this.username = username;
        this.score = score;
        this.authKey = authKey;
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

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}
