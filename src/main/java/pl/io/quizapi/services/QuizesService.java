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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizesService {

    private QuizesRepository quizesRepo;
    private QuestionsRepository questionsRepo;
    private AnswersRepository answersRepo;


    @Autowired
    public QuizesService(QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository answersRepo) {
        this.quizesRepo = quizesRepo;
        this.questionsRepo = questionsRepo;
        this.answersRepo = answersRepo;
    }

    public Optional<Quiz> findById(Long id) {
        return quizesRepo.findById(id);
    }

    public QuizLabelDTO findByName(String name) {
        Quiz quiz = quizesRepo.findByName(name).get();

        if (quiz != null) {
            QuizLabelDTO dto = new QuizLabelDTO(quiz.getName(), quiz.getQuestions().size());
            return dto;
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
        Quiz quiz = quizesRepo.findByName(name).get();

        if (quiz != null) {
            QuizDTO quizDTO = mapQuizToDTO(quiz);
            return quizDTO;
        } else {
            return null;
        }
    }

    public List<QuizDTO> getAll() {
        List<Quiz> quizzes = (List<Quiz>) quizesRepo.findAll();
        List<QuizDTO> quizDTOS = new ArrayList<>();

        for (Quiz q : quizzes) {
            quizDTOS.add(mapQuizToDTO(q));
        }

        return quizDTOS;
    }


    public Iterable<Quiz> findAll() {
        return quizesRepo.findAll();
    }


    public void saveQuiz(QuizDTO quiz) {
        Quiz mappedQuiz = new Quiz(quiz.getName());
        quizesRepo.save(mappedQuiz);
        saveQuestions(quiz.getQuestions(), mappedQuiz);
    }

    public void deleteById(Long id) {
        quizesRepo.deleteById(id);
    }

    private QuizDTO mapQuizToDTO(Quiz quiz) {
        List<QuestionDTO> questions = new ArrayList<>();

        for (Question q : quiz.getQuestions()) {
            questions.add(mapQuestionToDTO(q));
        }

        return new QuizDTO(quiz.getName(), questions);
    }

    private QuestionDTO mapQuestionToDTO(Question question) {
        List<AnswerDTO> answers = new ArrayList<>();

        for (Answer a : question.getAnswers()) {
            answers.add(mapAnswerToDTO(a));
        }

        return new QuestionDTO(question.getQuestionText(), answers);
    }

    private AnswerDTO mapAnswerToDTO(Answer answer) {
        return new AnswerDTO(answer.getAnswerText(), answer.getResult());
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
