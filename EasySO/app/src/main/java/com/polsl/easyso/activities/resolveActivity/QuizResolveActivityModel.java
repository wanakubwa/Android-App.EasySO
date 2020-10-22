package com.polsl.easyso.activities.resolveActivity;

import com.polsl.easyso.activities.resolveActivity.listeners.OnModelCollectionChangedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelInitializedListener;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.question.AnswerDTO;
import com.polsl.easyso.services.dto.question.QuestionDTO;
import com.polsl.easyso.services.dto.question.QuizDTO;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizResolveActivityModel {

    private QuestionTopicDTO currentTopic;
    private OnModelInitializedListener onModelInitializedHandler;
    private OnModelCollectionChangedListener onModelCollectionChanged;

    private List<QuestionDTO> allQuestionsCollection = new ArrayList<>();
    private List<QuestionDTO> currentVisibleQuestions = new ArrayList<>();

    public QuizResolveActivityModel(QuestionTopicDTO currentTopic) {
        this.currentTopic = currentTopic;
    }

    public void setOnModelCollectionChanged(OnModelCollectionChangedListener onModelCollectionChanged) {
        this.onModelCollectionChanged = onModelCollectionChanged;
    }

    public void setOnModelInitializedHandler(OnModelInitializedListener onModelInitializedHandler) {
        this.onModelInitializedHandler = onModelInitializedHandler;
    }

    public List<QuestionDTO> getCurrentVisibleQuestions() {
        return currentVisibleQuestions;
    }

    public void setCurrentVisibleQuestions(List<QuestionDTO> currentVisibleQuestions) {
        this.currentVisibleQuestions = currentVisibleQuestions;

    }

    public QuestionTopicDTO getCurrentTopic() {
        return currentTopic;
    }

    public void setCurrentTopic(QuestionTopicDTO currentTopic) {
        this.currentTopic = currentTopic;
    }

    public void initialize() {
        QuizServices retrofitClient = RetrofitClientFacade.getRetrofitInstance().create(QuizServices.class);
        final Call<QuizDTO> currentQuiz = retrofitClient.getQuizForTopic(currentTopic.getLabel());
        currentQuiz.enqueue(new Callback<QuizDTO>() {

            @Override
            public void onResponse(Call<QuizDTO> call, Response<QuizDTO> response) {
                allQuestionsCollection = response.body().getQuestionsCollection();
                onModelInitializedHandler.onInitializedSuccess();
            }

            @Override
            public void onFailure(Call<QuizDTO> call, Throwable throwable) {
            }
        });
    }

    public List<QuestionDTO> getRandomQuestionsAmmount(int ammount)
    {
        currentVisibleQuestions.clear();

        if(allQuestionsCollection.size() < 1)
        {
            return currentVisibleQuestions;
            //throw new InvalidParameterException();
        }

        // todo; tak wiem !!!!!!!!
        for(int i =0; i < ammount; i++)
        {
            // Glebokie kopiowanie oryginalnych elementow.
            currentVisibleQuestions.add(new QuestionDTO(allQuestionsCollection.get(i)));
        }

        return currentVisibleQuestions;
    }

    public void updateQuestionAnswerStatus(int questionId, int answerId)
    {
        QuestionDTO currentVisibleQuestion = getDisplayedQuestionById(questionId);
        if(currentVisibleQuestion == null){
            throw new InvalidParameterException();
        }

        AnswerDTO selectedAnswer = currentVisibleQuestion.getAnswerById(answerId);
        if(selectedAnswer == null){
            throw new InvalidParameterException();
        }

        selectedAnswer.setIsUserSelect(!selectedAnswer.getIsUserSelect());
    }

    public QuestionDTO getDisplayedQuestionById(int questionId) {

        QuestionDTO output = null;

        for(QuestionDTO question : currentVisibleQuestions){
            if(question.getId() == questionId){
                output = question;
                break;
            }
        }

        return output;
    }
}
