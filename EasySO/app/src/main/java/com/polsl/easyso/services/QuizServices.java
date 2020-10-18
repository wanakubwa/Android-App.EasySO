package com.polsl.easyso.services;

import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuizServices {

    @GET("api/categories")
    Call<List<QuizCategoryDTO>> getQuizzesCategories();

    @GET("api/label/{quiz_label_name}")
    Call<List<QuestionTopicDTO>> getTopicsForQuizCategoryLabel(@Path("quiz_label_name") String quizLabelName);
}
