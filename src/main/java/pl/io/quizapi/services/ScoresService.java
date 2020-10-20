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
    private QuizesRepository quizzesRepo;

    @Autowired
    public ScoresService(ScoresRepository scoresRepo, QuizesRepository quizzesRepo) {
        this.scoresRepo = scoresRepo;
        this.quizzesRepo = quizzesRepo;
    }

    public List<ScoreDTO> getAllScores() {
        List<Score> scores = (ArrayList<Score>) scoresRepo.findAll();
        List<ScoreDTO> scoreDTOS = new ArrayList<>();

        for (Score s : scores) {
            ScoreDTO scoreDTO = new ScoreDTO(s.getUsername(), s.getScore(), s.getQuizName());
            scoreDTOS.add(scoreDTO);
        }

        return scoreDTOS;
    }

    public boolean addScore(ScoreDTO scoreDTO) {
        Quiz quiz = quizzesRepo.findByName(scoreDTO.getQuizName()).orElse(null);

        if (quiz != null) {
            Score score = new Score(scoreDTO.getUsername(), scoreDTO.getScore(), scoreDTO.getUsername(), quiz);
            scoresRepo.save(score);
            return true;
        } else {
            return false;
        }
    }
}
