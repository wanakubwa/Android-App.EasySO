package com.polsl.easyso.activities.resolveActivity;

import android.content.Intent;
import android.os.Bundle;

import com.polsl.easyso.R;
import com.polsl.easyso.activities.resolveActivity.fragments.QuizResolveFragmentBase;
import com.polsl.easyso.activities.resolveActivity.fragments.QuizTestFragement;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelCollectionChangedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelInitializedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnStatisticsChangedListener;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.dialogs.StatisticsSendPopUpDialog;
import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.question.QuestionDTO;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.security.InvalidParameterException;
import java.util.List;

public class QuizResolveActivity extends AppCompatActivity implements OnModelInitializedListener, OnModelCollectionChangedListener, OnStatisticsChangedListener {

    private static QuizResolveActivity instance;
    private QuizResolveActivityModel model;

    private QuizResolveFragmentBase.TypeLabel defaultQuizFragmentType = QuizResolveFragmentBase.TypeLabel.TEST_MODE;
    private QuizResolveFragmentBase currentFragement = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_resolve2);
        instance = this;

        initialize();
        initializeActionBar();
    }

    @Override
    public void onBackPressed() {
        if(model.getStatistics().getScore() == 0){
            super.onBackPressed();
            return;
        }

        StatisticsSendPopUpDialog popup = new StatisticsSendPopUpDialog(this);
        popup.show();
    }

    public static QuizResolveActivity getInstance() {
        return instance;
    }

    public void onAnswerSelected(int questionId, int answerId) {
        try{
            model.updateQuestionAnswerStatus(questionId, answerId);
            onCollectionChanged();
        } catch (InvalidParameterException ex){
            //todo;
        }
    }

    public void validateSelectedAnswers() {
        model.validateDisplayedQuestions();
    }

    public void refreshDiaplayedQuestions(int ammount){
        model.refreshCurrentQuestions(ammount);
    }

    public int getStatisticsSumOfQuestions(){
        return model.getStatistics().getSumOfQuestions();
    }

    public int getSumOfCorrectAnswers(){
        return model.getStatistics().getSumOfCorrectAnswers();
    }

    public List<QuestionDTO> getRandomQuestions(int ammount) {
        return model.getRandomQuestionsAmmount(ammount);
    }

    public List<QuestionDTO> getCurrentQuestions() {
        return model.getCurrentVisibleQuestions();
    }

    public int getScoreValue(){
        return model.getStatistics().getScore();
    }

    // ########## Callbacks - START ###########

    @Override
    public void onInitializedSuccess() {
        // Ustawienie domyslnego fragementu.
        trySetFragment(model.getQuizFragmentByTypeLabel(defaultQuizFragmentType));
    }

    @Override
    public void onCollectionChanged() {
        QuizTestFragement fragement = (QuizTestFragement) getSupportFragmentManager().findFragmentById(R.id.quiz_resolve_activity_fragment_parent);
        if(fragement != null) {
            fragement.refreshDisplayedQuestions();
        }
    }

    @Override
    public void onStatisticsChanged() {
        QuizTestFragement fragement = (QuizTestFragement) getSupportFragmentManager().findFragmentById(R.id.quiz_resolve_activity_fragment_parent);
        if(fragement != null) {
            fragement.refreshStatisticsSection();
        }
    }

    // ########## Callbacks - END ###########

    private void trySetFragment(QuizResolveFragmentBase toAddFragement) {
        if(toAddFragement == null){
            return;
        }
        currentFragement = toAddFragement;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.quiz_resolve_activity_fragment_parent, toAddFragement);
        transaction.commit();
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
    }
}
