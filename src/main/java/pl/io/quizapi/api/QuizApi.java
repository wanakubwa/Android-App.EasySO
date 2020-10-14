package pl.io.quizapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.io.quizapi.dao.dtos.QuizDTO;
import pl.io.quizapi.dao.dtos.QuizLabelDTO;
import pl.io.quizapi.services.AnswersService;
import pl.io.quizapi.services.QuestionsService;
import pl.io.quizapi.services.QuizesService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizApi {

    private QuizesService quizesService;
    private QuestionsService questionsService;
    private AnswersService answersService;

    @Autowired
    public QuizApi(QuizesService quizesService, QuestionsService questionsService, AnswersService answersService) {
        this.quizesService = quizesService;
        this.questionsService = questionsService;
        this.answersService = answersService;
    }

    @GetMapping("/quizzes")
    public List<QuizDTO> getAllQuizzes() {
        return quizesService.getAll();
    }

    @GetMapping("/labels")
    public List<QuizLabelDTO> getAllQuizLabels() {
        return quizesService.getAllQuizLabels();
    }

    @GetMapping("/quiz/{name}")
    public QuizLabelDTO findByName(@PathVariable String name) {
        return quizesService.findByName(name);
    }

    @PostMapping("/quiz")
    public ResponseEntity addQuiz(@RequestBody QuizDTO quiz) {
        quizesService.saveQuiz(quiz);
        return ResponseEntity.ok("success");
    }


}
