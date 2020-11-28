package pl.io.quizapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.io.quizapi.dao.dtos.CategoryDTO;
import pl.io.quizapi.services.CategoriesService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QuizCategoriesController {
    private CategoriesService categoriesService;

    @Autowired
    public QuizCategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoriesService.getAllCategories();
    }

}
