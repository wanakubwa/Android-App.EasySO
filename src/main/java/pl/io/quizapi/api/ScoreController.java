package pl.io.quizapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.io.quizapi.dao.dtos.AuthScoreDTO;
import pl.io.quizapi.dao.dtos.ScoreDTO;
import pl.io.quizapi.services.ScoresService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ScoreController {
    private ScoresService scoresService;
    private final String AUTH = "382ffd9e8ce93285d03433e955e179d5";

    @Autowired
    public ScoreController(ScoresService scoresService) {
        this.scoresService = scoresService;
    }

    @GetMapping("/scores")
    public List<ScoreDTO> getScores() {
        return scoresService.getAllScores();
    }

    @PostMapping("/score")
    public ResponseEntity addScore(@RequestBody AuthScoreDTO score) {

        if (score.getAuthKey().equals(this.AUTH)) {
            ScoreDTO scoreDTO = new ScoreDTO(score.getUsername(), score.getScore());
            scoresService.addScore(scoreDTO);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }
}
