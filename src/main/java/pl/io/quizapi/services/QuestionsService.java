package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.QuestionsRepository;
import pl.io.quizapi.dao.entities.Question;

import java.util.Optional;

@Service
public class QuestionsService {

    private QuestionsRepository questionsRepository;

    @Autowired
    public QuestionsService(QuestionsRepository questionsRepository){
        this.questionsRepository = questionsRepository;
    }

    public Optional<Question> findById(Long id) {
        return questionsRepository.findById(id);
    }

    public Iterable<Question> findAll() {
        return questionsRepository.findAll();
    }

    public Question save(Question question){
        return questionsRepository.save(question);
    }

    public void deleteById(Long id){
        questionsRepository.deleteById(id);
    }
}
