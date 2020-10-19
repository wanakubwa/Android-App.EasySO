package pl.io.quizapi.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.io.quizapi.dao.dtos.CategoryDTO;
import pl.io.quizapi.dao.dtos.QuizDTO;
import pl.io.quizapi.dao.dtos.QuizLabelDTO;
import pl.io.quizapi.dao.dtos.ScoreDTO;
import pl.io.quizapi.services.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizApi {

    private QuizesService quizesService;
    private QuestionsService questionsService;
    private AnswersService answersService;
    private CategoriesService categoriesService;
    private ScoresService scoresService;

    private ModelMapper modelMapper;

    @Autowired
    public QuizApi(ModelMapper modelMapper, CategoriesService categoriesService, ScoresService scoresService, QuizesService quizesService, QuestionsService questionsService, AnswersService answersService) {
        this.modelMapper = modelMapper;
        this.quizesService = quizesService;
        this.questionsService = questionsService;
        this.answersService = answersService;
        this.categoriesService = categoriesService;
        this.scoresService = scoresService;
    }

    @GetMapping("/quizzes")
    public List<QuizDTO> getAllQuizzes() {
        return quizesService.getAllQuizzes();
    }

    @GetMapping("/labels")
    public List<QuizLabelDTO> getAllQuizLabels() {
        return quizesService.getAllQuizLabels();
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @GetMapping("/label/{category}")
    public List<QuizLabelDTO> getAllQuizzesFromCategory(@PathVariable String category) {
        return categoriesService.getAllQuizzesFromCategory(category);
    }

    @GetMapping("/quiz/{name}")
    public QuizDTO findByName(@PathVariable String name) {
        return quizesService.findByName(name);
    }

    @GetMapping("/scores")
    public List<ScoreDTO> getScores() {
        return scoresService.getAllScores();
    }

    @PostMapping("/score")
    public ResponseEntity addScore(@RequestBody ScoreDTO score) {
        boolean actionResult = scoresService.addScore(score);
        if (actionResult) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity addQuiz(@RequestBody QuizDTO quiz) {
        quizesService.saveQuiz(quiz);
        return ResponseEntity.ok("success");
    }


}
