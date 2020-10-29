package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.QuizesRepository;
import pl.io.quizapi.dao.ScoresRepository;
import pl.io.quizapi.dao.dtos.ScoreDTO;
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
            ScoreDTO scoreDTO = new ScoreDTO(s.getUsername(), s.getScore());
            scoreDTOS.add(scoreDTO);
        }

        return scoreDTOS;
    }

    public void addScore(ScoreDTO scoreDTO) {

        Score score = scoresRepo.findByUsername(scoreDTO.getUsername());

        if (score == null) {
            scoresRepo.save(new Score(scoreDTO.getUsername(), scoreDTO.getScore()));
        } else {
            int currentScore = score.getScore() + scoreDTO.getScore();
            score.setScore(currentScore);
            scoresRepo.save(score);
        }
    }
}
