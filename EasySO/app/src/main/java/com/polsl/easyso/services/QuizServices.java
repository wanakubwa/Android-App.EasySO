package com.polsl.easyso.services;

import com.polsl.easyso.services.dto.QuizCategoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuizServices {

    @GET("api/categories")
    Call<List<QuizCategoryDTO>> getQuizzesCategories();
}
