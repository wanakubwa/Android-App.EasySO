package pl.io.quizapi.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.io.quizapi.dao.dtos.QuizLabelDTO;
import pl.io.quizapi.services.CategoriesService;
import pl.io.quizapi.services.QuizesService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QuizLabelsController {
    private QuizesService quizesService;
    private CategoriesService categoriesService;

    @Autowired
    public QuizLabelsController(CategoriesService categoriesService, QuizesService quizesService) {
        this.quizesService = quizesService;
        this.categoriesService = categoriesService;
    }

    @GetMapping("/labels")
    public List<QuizLabelDTO> getAllQuizLabels() {
        return quizesService.getAllQuizLabels();
    }

    @GetMapping("/label/{category}")
    public List<QuizLabelDTO> getAllQuizzesFromCategory(@PathVariable String category) {
        return categoriesService.getAllQuizzesFromCategory(category);
    }
}
