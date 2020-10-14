package pl.io.quizapi.dao.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Quiz> quizzes;

}
