package com.polsl.easyso.services;

import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.QuizCategoryDTO;
import com.polsl.easyso.services.dto.question.QuizDTO;
import com.polsl.easyso.services.dto.score.ScoreDTO;
import com.polsl.easyso.services.dto.score.ScorePostDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QuizServices {

    @GET("api/categories")
    Call<List<QuizCategoryDTO>> getQuizzesCategories();

    @GET("api/label/{quiz_label_name}")
    Call<List<QuestionTopicDTO>> getTopicsForQuizCategoryLabel(@Path("quiz_label_name") String quizLabelName);

    @GET("api/quiz/{topic_label}")
    Call<QuizDTO> getQuizForTopic(@Path("topic_label") String topicLabel);

    @POST("api/score")
    Call<ScorePostDTO> setScore(@Body ScorePostDTO score);
}
