package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.CategoriesRepository;
import pl.io.quizapi.dao.dtos.CategoryDTO;
import pl.io.quizapi.dao.dtos.QuizLabelDTO;
import pl.io.quizapi.dao.entities.Category;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepo;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public List<CategoryDTO> getAllCategories() {

        return ((List<Category>) categoriesRepo.findAll())
                .stream()
                .map(category -> new CategoryDTO(category.getName(), category.getQuizzes().size()))
                .collect(Collectors.toList());
    }


    public List<QuizLabelDTO> getAllQuizzesFromCategory(String categoryName) {
        Category category = categoriesRepo.findByName(categoryName).orElseThrow(RuntimeException::new);

        return category.getQuizzes()
                .stream()
                .map(quiz -> new QuizLabelDTO(quiz.getName(), quiz.getQuestions().size()))
                .collect(Collectors.toList());
    }
}
