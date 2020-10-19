package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.AnswersRepository;
import pl.io.quizapi.dao.QuestionsRepository;
import pl.io.quizapi.dao.QuizesRepository;
import pl.io.quizapi.dao.dtos.AnswerDTO;
import pl.io.quizapi.dao.dtos.QuestionDTO;
import pl.io.quizapi.dao.dtos.QuizDTO;
import pl.io.quizapi.dao.dtos.QuizLabelDTO;
import pl.io.quizapi.dao.entities.Answer;
import pl.io.quizapi.dao.entities.Question;
import pl.io.quizapi.dao.entities.Quiz;
import pl.io.quizapi.dao.helper.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizesService {

    private QuizesRepository quizesRepo;
    private QuestionsRepository questionsRepo;
    private AnswersRepository answersRepo;
    private Mapper mapper;

    @Autowired
    public QuizesService(Mapper mapper, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository answersRepo) {
        this.quizesRepo = quizesRepo;
        this.questionsRepo = questionsRepo;
        this.answersRepo = answersRepo;
        this.mapper = mapper;
    }

    public Optional<Quiz> findById(Long id) {
        return quizesRepo.findById(id);
    }

    public QuizDTO findByName(String name) {
        Quiz quiz = quizesRepo.findByName(name).orElse(null);

        if (quiz != null) {
            return mapper.mapQuizToDTO(quiz);
        } else {
            return null;
        }
    }

    public List<QuizLabelDTO> getAllQuizLabels() {
        List<Quiz> quizzes = (List<Quiz>) quizesRepo.findAll();
        List<QuizLabelDTO> labels = new ArrayList<>();

        for (Quiz q : quizzes) {
            labels.add(new QuizLabelDTO(q.getName(), q.getQuestions().size()));
        }

        return labels;
    }

    public QuizDTO findQuizByName(String name) {
        Quiz quiz = quizesRepo.findByName(name).orElse(null);

        if (quiz != null) {
            return mapper.mapQuizToDTO(quiz);
        } else {
            return null;
        }
    }

    public List<QuizDTO> getAllQuizzes() {
        List<Quiz> quizzes = (List<Quiz>) quizesRepo.findAll();
        List<QuizDTO> quizDTOS = new ArrayList<>();

        for (Quiz q : quizzes) {
            quizDTOS.add(mapper.mapQuizToDTO(q));
        }

        return quizDTOS;
    }

    public void saveQuiz(QuizDTO quiz) {
        Quiz mappedQuiz = new Quiz(quiz.getName());
        quizesRepo.save(mappedQuiz);
        saveQuestions(quiz.getQuestions(), mappedQuiz);
    }

    public void deleteById(Long id) {
        quizesRepo.deleteById(id);
    }

    private void saveQuestions(List<QuestionDTO> questions, Quiz quiz) {
        for (QuestionDTO q : questions) {
            Question question = new Question(q.getQuestion(), quiz);
            questionsRepo.save(question);
            saveAnswers(q.getAnswers(), question);
        }
    }

    private void saveAnswers(List<AnswerDTO> answers, Question question) {
        for (AnswerDTO a : answers) {
            Answer answer = new Answer(a.getAnswer(), a.getResult(), question);
            answersRepo.save(answer);
        }
    }
}
