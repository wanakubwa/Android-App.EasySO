package pl.io.quizapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.CategoriesRepository;
import pl.io.quizapi.dao.dtos.*;
import pl.io.quizapi.dao.entities.Answer;
import pl.io.quizapi.dao.entities.Category;
import pl.io.quizapi.dao.entities.Question;
import pl.io.quizapi.dao.entities.Quiz;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepo;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = (List<Category>) categoriesRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category c : categories) {
            categoryDTOS.add(new CategoryDTO(c.getName(), c.getQuizzes().size()));
        }

        return categoryDTOS;
    }


    public List<QuizLabelDTO> getAllQuizzesFromCategory(String categoryName) {
        Category category = categoriesRepo.findByName(categoryName).orElse(null);
        if (category != null) {
            List<QuizLabelDTO> retVal = new ArrayList<>();

            for (Quiz q : category.getQuizzes()) {
                retVal.add(new QuizLabelDTO(q.getName(), q.getQuestions().size()));
            }
            return retVal;
        } else {
            return null;
        }
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

}
