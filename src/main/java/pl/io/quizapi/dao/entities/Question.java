package pl.io.quizapi.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="question")
public class Question implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String questionText;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private List<Answer> answers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Quiz quiz;

    public Question() {
    }

    public Question(String questionText,Quiz quiz) {
        this.questionText = questionText;
        this.quiz = quiz;
    }

    public Question(String questionText, List<Answer> answers, Quiz quiz) {
        this.questionText = questionText;
        this.answers = answers;
        this.quiz = quiz;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(String questionText,Quiz quiz,List<Answer> answers) {
        this.questionText = questionText;
        this.quiz = quiz;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }


}
