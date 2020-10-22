package com.polsl.easyso.activities.resolveActivity;

import android.content.Intent;
import android.os.Bundle;

import com.polsl.easyso.R;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelCollectionChangedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelInitializedListener;
import com.polsl.easyso.adapters.QuizResolveAdapter;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.dto.QuestionTopicDTO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.security.InvalidParameterException;

public class QuizResolveActivity extends AppCompatActivity implements OnModelInitializedListener, OnModelCollectionChangedListener {

    private static QuizResolveActivity instance;
    private QuizResolveActivityModel model;

    private RecyclerView recyclerView;
    private QuizResolveAdapter questionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_resolve2);
        instance = this;

        recyclerView = (RecyclerView) findViewById(R.id.quiz_questions_list);
        recyclerView.setHasFixedSize(true);

        initialize();
    }

    public static QuizResolveActivity getInstance() {
        return instance;
    }

    public void onAnswerSelected(int questionId, int answerId) {

        try{
            model.updateQuestionAnswerStatus(questionId, answerId);
            questionsAdapter.notifyDataSetChanged();
        } catch (InvalidParameterException ex){

        }
    }

    // ########## Callbacks - START ###########

    @Override
    public void onInitializedSuccess() {
        refreshView();
    }

    @Override
    public void onCollectionChanged() {
        //todo;
    }

    // ########## Callbacks - END ###########

    private void initialize()
    {
        Intent intent = getIntent();
        QuestionTopicDTO currentTopic = (QuestionTopicDTO) intent.getSerializableExtra(Constants.QUIZ_TOPIC_INTENT_NAME);

        model = new QuizResolveActivityModel(currentTopic);
        model.setOnModelInitializedHandler(this);
        model.setOnModelCollectionChanged(this);
        model.initialize();

        //Toast.makeText(this, "Unable to load from server!", Toast.LENGTH_SHORT).show();
    }

    private void refreshView()
    {
        questionsAdapter = new QuizResolveAdapter(model.getRandomQuestionsAmmount(2));
        recyclerView.setAdapter(questionsAdapter);
    }
}
