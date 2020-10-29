package com.polsl.easyso.activities.resolveActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.polsl.easyso.R;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelCollectionChangedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelInitializedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnStatisticsChangedListener;
import com.polsl.easyso.adapters.QuizResolveAdapter;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.dto.QuestionTopicDTO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;

import java.security.InvalidParameterException;

public class QuizResolveActivity extends AppCompatActivity implements OnModelInitializedListener, OnModelCollectionChangedListener, OnStatisticsChangedListener {

    private static QuizResolveActivity instance;
    private QuizResolveActivityModel model;

    private RecyclerView recyclerView;
    private QuizResolveAdapter questionsAdapter;

    private TextView questionsCountText;
    private TextView correctAnswersCountText;
    private TextView scoreCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_resolve2);
        instance = this;

        recyclerView = (RecyclerView) findViewById(R.id.quiz_questions_list);
        recyclerView.setHasFixedSize(true);
        questionsCountText = (TextView) findViewById(R.id.statistics_questions_count);
        correctAnswersCountText = (TextView) findViewById(R.id.statistics_correct_answers_count);
        scoreCountText = (TextView) findViewById(R.id.statistics_points_count);

        initialize();
        initializeBottomToolBar();
        initializeActionBar();
        refreshStatisticsSection();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void sendCurrentTopicToIntent() {
        Intent intent = getIntent();
        intent.putExtra(Constants.QUIZ_TOPIC_INTENT_NAME, model.getCurrentTopic());
    }

    public static QuizResolveActivity getInstance() {
        return instance;
    }

    public void onAnswerSelected(int questionId, int answerId) {

        try{
            model.updateQuestionAnswerStatus(questionId, answerId);
            questionsAdapter.notifyDataSetChanged();
        } catch (InvalidParameterException ex){
            //todo;
        }
    }

    // ########## Callbacks - START ###########

    @Override
    public void onInitializedSuccess() {
        refreshView();
    }

    @Override
    public void onCollectionChanged() {
        if(questionsAdapter != null){
            questionsAdapter.setQuestionsCollection(model.getCurrentVisibleQuestions());
        }
    }

    @Override
    public void onStatisticsChanged() {
        refreshStatisticsSection();
    }

    // ########## Callbacks - END ###########

    private void refreshStatisticsSection(){
        questionsCountText.setText(String.valueOf(model.getStatistics().getSumOfQuestions()));
        correctAnswersCountText.setText(String.valueOf(model.getStatistics().getSumOfCorrectAnswers()));
        scoreCountText.setText(String.valueOf(model.getStatistics().getScore()));
    }

    private void initializeActionBar(){
        ActionBar topActionBar = getSupportActionBar();
        if(topActionBar != null){
            topActionBar.setDisplayHomeAsUpEnabled(false);
            topActionBar.setTitle(model.getCurrentTopic().getLabel().trim());
        }
    }

    private void initialize()
    {
        Intent intent = getIntent();
        QuestionTopicDTO currentTopic = (QuestionTopicDTO) intent.getSerializableExtra(Constants.QUIZ_TOPIC_INTENT_NAME);

        model = new QuizResolveActivityModel(currentTopic);
        model.setOnModelInitializedHandler(this);
        model.setOnModelCollectionChanged(this);
        model.setOnStatisticsChanged(this);
        model.initialize();

        //Toast.makeText(this, "Unable to load from server!", Toast.LENGTH_SHORT).show();
    }

    private void refreshView()
    {
        questionsAdapter = new QuizResolveAdapter(model.getRandomQuestionsAmmount(2));
        recyclerView.setAdapter(questionsAdapter);
    }

    private void initializeBottomToolBar(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.quiz_resolve_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.quiz_resolve_bottom_navigation_action_check:
                        model.validateDisplayedQuestions();
                        break;
                    case R.id.quiz_resolve_bottom_navigation_action_roll:
                        model.refreshCurrentQuestions(2);
                        break;
                }
                return true;
            }
        });
    }
}
