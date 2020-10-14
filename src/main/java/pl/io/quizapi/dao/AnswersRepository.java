package pl.io.quizapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.io.quizapi.dao.entities.Answer;

@Repository
public interface AnswersRepository extends CrudRepository<Answer,Long> {
}
