package pl.io.quizapi.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private Integer score;

    private String quizName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Quiz quiz;

    public Score() {
    }

    public Score(String username, Integer score) {
        this.username = username;
        this.score = score;
    }

    public Score(String username, Integer score, Quiz quiz) {
        this.username = username;
        this.score = score;
        this.quiz = quiz;
    }

    public Score(String username, Integer score, String quizName, Quiz quiz) {
        this.username = username;
        this.score = score;
        this.quiz = quiz;
        this.quizName = quizName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getQuizName() {
        return quizName;
    }

    public Quiz getQuiz() {
        return quiz;
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

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
