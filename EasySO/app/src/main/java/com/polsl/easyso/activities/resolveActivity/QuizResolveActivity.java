package com.polsl.easyso.activities.resolveActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.polsl.easyso.R;
import com.polsl.easyso.activities.MainActivity;
import com.polsl.easyso.activities.resolveActivity.callbacks.OnModelInitializedCallback;
import com.polsl.easyso.adapters.QuizResolveAdapter;
import com.polsl.easyso.adapters.QuizTopicAdapter;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.exceptions.ApiException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class QuizResolveActivity extends AppCompatActivity implements OnModelInitializedCallback {

    private static QuizResolveActivity instance;
    private QuizResolveActivityModel model;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_resolve2);
        instance = this;

        recyclerView = (RecyclerView) findViewById(R.id.quiz_questions_list);
        recyclerView.setHasFixedSize(true);

        initialize();
    }

    public static QuizResolveActivity getInstance()
    {
        return instance;
    }

    @Override
    public void OnInitializedSuccess() {
        refreshView();
    }

    private void initialize()
    {
        Intent intent = getIntent();
        QuestionTopicDTO currentTopic = (QuestionTopicDTO) intent.getSerializableExtra(Constants.QUIZ_TOPIC_INTENT_NAME);

        model = new QuizResolveActivityModel(currentTopic);
        model.setOnModelInitializedHandler(this);
        model.initialize();

        //Toast.makeText(this, "Unable to load from server!", Toast.LENGTH_SHORT).show();
    }

    private void refreshView()
    {
        QuizResolveAdapter adapter = new QuizResolveAdapter(model.getRandomQuestionsAmmount(2));
        recyclerView.setAdapter(adapter);
    }
}
