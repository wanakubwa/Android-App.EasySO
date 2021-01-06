package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.QuizesRepository;
import pl.io.quizapi.dao.ScoresRepository;
import pl.io.quizapi.dao.dtos.ScoreDTO;
import pl.io.quizapi.dao.entities.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        return ((ArrayList<Score>) scoresRepo.findAll())
                .stream()
                .map(score -> new ScoreDTO(score.getUsername(), score.getScore()))
                .collect(Collectors.toList());
    }

    public void addScore(ScoreDTO scoreDTO) {

        final Score scoreToSave = scoresRepo.findByUsername(scoreDTO.getUsername())
                .map(score -> {
                    int currentScore = score.getScore() + scoreDTO.getScore();
                    score.setScore(currentScore);
                    return score;
                })
                .orElseGet(() -> new Score(scoreDTO.getUsername(), scoreDTO.getScore()));

        scoresRepo.save(scoreToSave);
    }
}
