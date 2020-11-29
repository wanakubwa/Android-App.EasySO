package pl.io.quizapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.io.quizapi.dao.dtos.FullQuizDTO;
import pl.io.quizapi.dao.dtos.QuizDTO;
import pl.io.quizapi.dao.dtos.QuizLabelDTO;
import pl.io.quizapi.services.CategoriesService;
import pl.io.quizapi.services.QuizesService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QuizController {
    private QuizesService quizesService;
    private CategoriesService categoriesService;

    @Autowired
    public QuizController(QuizesService quizesService) {
        this.quizesService = quizesService;
    }

    @GetMapping("/quizzes")
    public List<QuizDTO> getAllQuizzes() {
        return quizesService.getAllQuizzes();
    }

    @GetMapping("/quiz/{name}")
    public QuizDTO findByName(@PathVariable String name) {
        return quizesService.findByName(name);
    }

    @GetMapping("/quiz/{category}/{name}")
    public QuizDTO findByCategoryAndName(@PathVariable String name, @PathVariable String category) {
       List<QuizLabelDTO> retVal = categoriesService.getAllQuizzesFromCategory(category);
        return quizesService.findByName(name);
    }

    @PostMapping("/quiz")
    public ResponseEntity addQuiz(@RequestBody QuizDTO quiz) {
        quizesService.saveQuiz(quiz);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/new-quiz")
    public ResponseEntity addNewQuiz(@RequestBody FullQuizDTO quiz){
        quizesService.saveNewQuiz(quiz);
        return ResponseEntity.ok().build();
    }

}
