package com.polsl.easyso.services;

import com.polsl.easyso.services.dto.score.ScoreDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScoreServices {

    @GET("api/scores")
    Call<List<ScoreDTO>> getAllScores();
}
