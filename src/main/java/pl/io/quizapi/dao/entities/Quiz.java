package pl.io.quizapi.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<Question> questions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category;

    public Quiz() {
    }

    public Quiz(String name) {
        this.name = name;
    }

    public Quiz(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Quiz(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Quiz(String name, List<Question> questions, Category category) {
        this.name = name;
        this.questions = questions;
        this.category = category;
    }

    public Quiz(String name, List<Question> questions, Category category, List<Score> scores) {
        this.name = name;
        this.questions = questions;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
