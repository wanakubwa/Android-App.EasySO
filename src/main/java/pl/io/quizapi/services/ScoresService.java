package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.QuizesRepository;
import pl.io.quizapi.dao.ScoresRepository;
import pl.io.quizapi.dao.dtos.ScoreDTO;
import pl.io.quizapi.dao.entities.Quiz;
import pl.io.quizapi.dao.entities.Score;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoresService {

    private ScoresRepository scoresRepo;
    private QuizesRepository quizesRepo;

    @Autowired
    public ScoresService(ScoresRepository scoresRepo, QuizesRepository quizesRepo) {
        this.scoresRepo = scoresRepo;
        this.quizesRepo = quizesRepo;
    }

    public List<ScoreDTO> getAllScores() {
        List<Score> scores = (List<Score>) scoresRepo.findAll();
        List<ScoreDTO> scoreDTOS = new ArrayList<>();

        for (Score s : scores) {
            scoreDTOS.add(mapScoreToDTO(s));
        }
        return scoreDTOS;
    }

    public boolean addScore(ScoreDTO scoreDTO) {
        Quiz quiz = quizesRepo.findByName(scoreDTO.getQuizName()).orElse(null);

        if (quiz != null) {
            scoresRepo.save(new Score(scoreDTO.getUsername(), scoreDTO.getScore(), scoreDTO.getUsername(), quiz));
            return true;
        } else {
            return false;
        }
    }


    private ScoreDTO mapScoreToDTO(Score score) {
        ScoreDTO scoreDTO = new ScoreDTO(score.getUsername(), score.getScore(), score.getQuizName());

        return scoreDTO;
    }
}
