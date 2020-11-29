package pl.io.quizapi.dao.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;


    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Quiz> quizzes;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Quiz> quizzes) {
        this.name = name;
        this.quizzes = quizzes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}

