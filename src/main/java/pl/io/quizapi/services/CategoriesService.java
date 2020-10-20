package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.CategoriesRepository;
import pl.io.quizapi.dao.dtos.CategoryDTO;
import pl.io.quizapi.dao.dtos.QuizLabelDTO;
import pl.io.quizapi.dao.entities.Category;
import pl.io.quizapi.dao.entities.Quiz;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepo;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepo) {
        this.categoriesRepo = categoriesRepo;

    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = (List<Category>) categoriesRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category c : categories) {
            CategoryDTO categoryDTO = new CategoryDTO(c.getName(), c.getQuizzes().size());
            categoryDTOS.add(categoryDTO);
        }

        return categoryDTOS;
    }


    public List<QuizLabelDTO> getAllQuizzesFromCategory(String categoryName) {
        Category category = categoriesRepo.findByName(categoryName).orElse(null);
        if (category != null) {
            List<QuizLabelDTO> retVal = new ArrayList<>();
            for (Quiz q : category.getQuizzes()) {
                QuizLabelDTO quizLabelDTO = new QuizLabelDTO(q.getName(), q.getQuestions().size());
                retVal.add(quizLabelDTO);
            }

            return retVal;
        } else {
            return null;
        }
    }


}
