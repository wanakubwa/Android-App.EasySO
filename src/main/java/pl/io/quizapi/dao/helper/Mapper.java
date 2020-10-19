package pl.io.quizapi.dao.helper;

import org.springframework.stereotype.Service;
import pl.io.quizapi.dao.dtos.AnswerDTO;
import pl.io.quizapi.dao.dtos.QuestionDTO;
import pl.io.quizapi.dao.dtos.QuizDTO;
import pl.io.quizapi.dao.entities.Answer;
import pl.io.quizapi.dao.entities.Question;
import pl.io.quizapi.dao.entities.Quiz;

import java.util.ArrayList;
import java.util.List;


@Service
public class Mapper {

    public QuizDTO mapQuizToDTO(Quiz quiz) {
        List<QuestionDTO> questions = new ArrayList<>();

        for (Question q : quiz.getQuestions()) {
            questions.add(mapQuestionToDTO(q));
        }

        return new QuizDTO(quiz.getName(), questions);
    }

    public QuestionDTO mapQuestionToDTO(Question question) {
        List<AnswerDTO> answers = new ArrayList<>();

        for (Answer a : question.getAnswers()) {
            answers.add(mapAnswerToDTO(a));
        }

        return new QuestionDTO(question.getId().intValue(), question.getQuestionText(), answers);
    }

    public AnswerDTO mapAnswerToDTO(Answer answer) {
        return new AnswerDTO(answer.getId().intValue(), answer.getAnswerText(), answer.getResult());
    }
}
