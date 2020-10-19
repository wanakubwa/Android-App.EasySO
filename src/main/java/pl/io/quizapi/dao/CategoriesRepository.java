package pl.io.quizapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.io.quizapi.dao.entities.Category;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
