package pl.io.quizapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.AnswersRepository;
import pl.io.quizapi.dao.CategoriesRepository;
import pl.io.quizapi.dao.QuestionsRepository;
import pl.io.quizapi.dao.QuizesRepository;
import pl.io.quizapi.dao.dtos.*;
import pl.io.quizapi.dao.entities.Answer;
import pl.io.quizapi.dao.entities.Category;
import pl.io.quizapi.dao.entities.Question;
import pl.io.quizapi.dao.entities.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizesService {

    private QuizesRepository quizzesRepo;
    private QuestionsRepository questionsRepo;
    private AnswersRepository answersRepo;
    private CategoriesRepository categoriesRepos;
    private ModelMapper modelMapper;

    @Autowired
    public QuizesService(ModelMapper modelMapper, QuizesRepository quizzesRepo, QuestionsRepository questionsRepo, AnswersRepository answersRepo, CategoriesRepository categoriesRepos) {
        this.quizzesRepo = quizzesRepo;
        this.questionsRepo = questionsRepo;
        this.answersRepo = answersRepo;
        this.modelMapper = modelMapper;
        this.categoriesRepos = categoriesRepos;
    }

    public QuizDTO findByName(String name) {
        Quiz quiz = quizzesRepo.findByName(name).orElseThrow(RuntimeException::new);

        return modelMapper.map(quiz, QuizDTO.class);
    }

    public List<QuizLabelDTO> getAllQuizLabels() {
        return ((List<Quiz>) quizzesRepo.findAll())
                .stream()
                .map(quiz -> new QuizLabelDTO(quiz.getName(), quiz.getQuestions().size()))
                .collect(Collectors.toList());
    }

    public List<QuizDTO> getAllQuizzes() {
        List<Quiz> quizzes = (List<Quiz>) quizzesRepo.findAll();
        List<QuizDTO> quizDTOS = new ArrayList<>();

        for (Quiz q : quizzes) {
            quizDTOS.add(modelMapper.map(q, QuizDTO.class));
        }

        return quizDTOS;
    }

    public void saveQuiz(QuizDTO quiz) {
        Quiz mappedQuiz = new Quiz(quiz.getName());
        quizzesRepo.save(mappedQuiz);
        saveQuestions(quiz.getQuestions(), mappedQuiz);
    }

    public void saveNewQuiz(FullQuizDTO quiz) {
        List<Category> categories = (List<Category>) categoriesRepos.findAll();
        String categoryName = quiz.getCategory();

        for (Category c : categories) {
            if (c.getName().equals(categoryName)) {
                Quiz mappedQuiz = new Quiz(quiz.getQuiz().getName(), c);
                quizzesRepo.save(mappedQuiz);
                saveQuestions(quiz.getQuiz().getQuestions(), mappedQuiz);
                return;
            }
        }

        Category category = new Category(categoryName);
        categoriesRepos.save(category);
        Quiz mappedQuiz = new Quiz(quiz.getQuiz().getName(), category);
        quizzesRepo.save(mappedQuiz);
        saveQuestions(quiz.getQuiz().getQuestions(), mappedQuiz);
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
