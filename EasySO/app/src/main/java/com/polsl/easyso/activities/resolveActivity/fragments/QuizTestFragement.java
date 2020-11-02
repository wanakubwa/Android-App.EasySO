package com.polsl.easyso.activities.resolveActivity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.polsl.easyso.R;
import com.polsl.easyso.adapters.QuizResolveAdapter;

public class QuizTestFragement extends QuizResolveFragmentBase {

    private RecyclerView recyclerView;
    private QuizResolveAdapter questionsAdapter;

    private TextView questionsCountText;
    private TextView correctAnswersCountText;
    private TextView scoreCountText;
    private BottomNavigationView bottomNavigation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_quiz_resolve_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.quiz_questions_list);
        recyclerView.setHasFixedSize(true);
        questionsCountText = (TextView) getActivity().findViewById(R.id.statistics_questions_count);
        correctAnswersCountText = (TextView) getActivity().findViewById(R.id.statistics_correct_answers_count);
        scoreCountText = (TextView) getActivity().findViewById(R.id.statistics_points_count);
        bottomNavigation = (BottomNavigationView) getActivity().findViewById(R.id.quiz_resolve_bottom_navigation);

        initializeBottomToolBar();
        refreshView();
        refreshStatisticsSection();
    }

    @Override
    public String getOptionName() {
        return getResources().getString(R.string.quiz_resolve_test_fragment_option);
    }

    @Override
    public TypeLabel getFragmentType() {
        return TypeLabel.TEST_MODE;
    }

    public void refreshStatisticsSection(){
        questionsCountText.setText(String.valueOf(parent.getStatisticsSumOfQuestions()));
        correctAnswersCountText.setText(String.valueOf(parent.getSumOfCorrectAnswers()));
        scoreCountText.setText(String.valueOf(parent.getScoreValue()));
    }

    public void refreshDisplayedQuestions() {
        questionsAdapter.setQuestionsCollection(parent.getCurrentQuestions());
    }

    private void initializeBottomToolBar(){
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.quiz_resolve_bottom_navigation_action_check:
                        parent.validateSelectedAnswers();
                        break;
                    case R.id.quiz_resolve_bottom_navigation_action_roll:
                        parent.refreshDiaplayedQuestions(2);
                        break;
                }
                return true;
            }
        });
    }

    private void refreshView()
    {
        questionsAdapter = new QuizResolveAdapter(parent.getRandomQuestions(2));
        recyclerView.setAdapter(questionsAdapter);
    }
}
