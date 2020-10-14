package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.AnswersRepository;
import pl.io.quizapi.dao.entities.Answer;

import java.util.Optional;

@Service
public class AnswersService {

    private AnswersRepository answersRepository;

    @Autowired
    public AnswersService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public Optional<Answer> findById(Long id) {
        return answersRepository.findById(id);
    }

    public Iterable<Answer> findAll() {
        return answersRepository.findAll();
    }

    public Answer save(Answer answer){
        return answersRepository.save(answer);
    }

    public void deleteById(Long id){
        answersRepository.deleteById(id);
    }

}
