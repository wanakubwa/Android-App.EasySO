package pl.io.quizapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.io.quizapi.dao.entities.Question;

@Repository
public interface QuestionsRepository extends CrudRepository<Question,Long> {
}
