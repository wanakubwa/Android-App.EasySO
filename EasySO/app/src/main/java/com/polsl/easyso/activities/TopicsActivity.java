package com.polsl.easyso.activities;

import android.content.Intent;
import android.os.Bundle;

import com.polsl.easyso.R;
import com.polsl.easyso.activities.resolveActivity.QuizResolveActivity;
import com.polsl.easyso.adapters.QuizTopicAdapter;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicsActivity extends AppCompatActivity {

    private static TopicsActivity instance;

    private RecyclerView recyclerView;
    private QuizCategoryDTO currentQuizCategory;

    public static TopicsActivity getInstance() {
        return instance;
    }

    public void onTopicClicked(@NonNull QuestionTopicDTO topicDTO)
    {
        if(topicDTO.getQuestionsCount() < 1)
        {
            Toast.makeText(TopicsActivity.this, "No questions in topic: \n" + topicDTO.getLabel(), Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, QuizResolveActivity.class);
        intent.putExtra(Constants.QUIZ_TOPIC_INTENT_NAME, topicDTO);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        instance = this;

        recyclerView = (RecyclerView) findViewById(R.id.quizzes_topics_recycle_view);
        recyclerView.setHasFixedSize(true);

        refreshView();
        initializeActionBar();
    }

    private void refreshView()
    {
        //todo; do modelu to wszytsko z dolu. Leci tu null bo nie ma w intecie juz tego obj.
        Intent intent = getIntent();
        currentQuizCategory = (QuizCategoryDTO) intent.getSerializableExtra(Constants.QUIZ_CATEGORY_INTENT_NAME);

        QuizServices retrofitClient = RetrofitClientFacade.getRetrofitInstance().create(QuizServices.class);
        Call<List<QuestionTopicDTO>> allCategories = retrofitClient.getTopicsForQuizCategoryLabel(currentQuizCategory.getName());
        allCategories.enqueue(new Callback<List<QuestionTopicDTO>>() {

            @Override
            public void onResponse(Call<List<QuestionTopicDTO>> call, Response<List<QuestionTopicDTO>> response) {
                showTopics(response.body());
                Toast.makeText(TopicsActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<QuestionTopicDTO>> call, Throwable throwable) {
                Toast.makeText(TopicsActivity.this, "Unable to load", Toast.LENGTH_SHORT).show();
            }
        });

        Toast.makeText(this, currentQuizCategory.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showTopics(List<QuestionTopicDTO> topics)
    {
        // Tworzenie adaptera.
        QuizTopicAdapter adapter = new QuizTopicAdapter(topics);
        recyclerView.setAdapter(adapter);
    }

    private void initializeActionBar(){
        ActionBar topActionBar = getSupportActionBar();
        if(topActionBar != null){
            topActionBar.setDisplayHomeAsUpEnabled(true);
            topActionBar.setTitle(currentQuizCategory.getName().trim());
        }
    }
}
