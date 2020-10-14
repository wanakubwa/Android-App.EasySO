package pl.io.quizapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.io.quizapi.dao.entities.Quiz;

import java.util.Optional;

@Repository
public interface QuizesRepository extends CrudRepository<Quiz, Long> {

    Optional<Quiz> findByName(String name);
}
