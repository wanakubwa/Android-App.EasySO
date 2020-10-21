package com.polsl.easyso.activities.resolveActivity;

import android.content.Context;
import android.content.Intent;
import android.view.Surface;
import android.widget.Toast;

import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.QuizCategoryDTO;
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
    private QuizResolveActivity viewController;

    private List<QuestionDTO> allQuestionsCollection = new ArrayList<>();

    public QuizResolveActivityModel() {
    }

    public QuizResolveActivityModel(QuestionTopicDTO currentTopic, QuizResolveActivity viewController) {
        this.currentTopic = currentTopic;
        this.viewController = viewController;
    }

    public QuestionTopicDTO getCurrentTopic() {
        return currentTopic;
    }

    public void setCurrentTopic(QuestionTopicDTO currentTopic) {
        this.currentTopic = currentTopic;
    }

    public void initialize()
    {
        QuizServices retrofitClient = RetrofitClientFacade.getRetrofitInstance().create(QuizServices.class);
        final Call<QuizDTO> currentQuiz = retrofitClient.getQuizForTopic(currentTopic.getLabel());
        currentQuiz.enqueue(new Callback<QuizDTO>() {

            @Override
            public void onResponse(Call<QuizDTO> call, Response<QuizDTO> response) {
                allQuestionsCollection = response.body().getQuestionsCollection();
            }

            @Override
            public void onFailure(Call<QuizDTO> call, Throwable throwable) {
                Toast.makeText(viewController, "Unable to load from server!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<QuestionDTO> getRandomQuestionsAmmount(int ammount)
    {
        final List<QuestionDTO> output = new ArrayList<>();

        if(allQuestionsCollection.size() < 1)
        {
            throw new InvalidParameterException();
        }

        // todo; tak wiem !!!!!!!!
        for(int i =0; i < ammount; i++)
        {
            output.add(allQuestionsCollection.get(i));
        }

        return output;
    }
}
