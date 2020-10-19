package pl.io.quizapi.dao;

import org.springframework.data.repository.CrudRepository;
import pl.io.quizapi.dao.entities.Score;

public interface ScoresRepository extends CrudRepository<Score, Long> {
}
