package pl.io.quizapi.dao;

import org.springframework.data.repository.CrudRepository;
import pl.io.quizapi.dao.entities.Score;

import java.util.Optional;

public interface ScoresRepository extends CrudRepository<Score, Long> {

    Optional<Score> findByUsername(String username);
}
