package com.polsl.easyso.activities.resolveActivity;

import android.content.Context;
import android.content.Intent;
import android.view.Surface;
import android.widget.Toast;

import com.polsl.easyso.activities.resolveActivity.callbacks.OnModelInitializedCallback;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.QuizCategoryDTO;
import com.polsl.easyso.services.dto.question.QuestionDTO;
import com.polsl.easyso.services.dto.question.QuizDTO;
import com.polsl.easyso.services.exceptions.ApiException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizResolveActivityModel {

    private QuestionTopicDTO currentTopic;

    private List<QuestionDTO> allQuestionsCollection = new ArrayList<>();
    private OnModelInitializedCallback onModelInitializedHandler;

    public QuizResolveActivityModel(QuestionTopicDTO currentTopic) {
        this.currentTopic = currentTopic;
    }

    public void setOnModelInitializedHandler(OnModelInitializedCallback onModelInitializedHandler) {
        this.onModelInitializedHandler = onModelInitializedHandler;
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
                onModelInitializedHandler.OnInitializedSuccess();
            }

            @Override
            public void onFailure(Call<QuizDTO> call, Throwable throwable) {
            }
        });
    }

    public List<QuestionDTO> getRandomQuestionsAmmount(int ammount)
    {
        final List<QuestionDTO> output = new ArrayList<>();

        if(allQuestionsCollection.size() < 1)
        {
            return output;
            //throw new InvalidParameterException();
        }

        // todo; tak wiem !!!!!!!!
        for(int i =0; i < ammount; i++)
        {
            output.add(allQuestionsCollection.get(i));
        }

        return output;
    }
}
