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
import com.polsl.easyso.services.dto.question.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

public class QuizTestFragment extends QuizResolveFragmentBase {

    private RecyclerView recyclerView;
    private QuizResolveAdapter questionsAdapter;

    private TextView questionsCountText;
    private TextView correctAnswersCountText;
    private BottomNavigationView bottomNavigation;

    @Override
    public String getOptionName() {
        return "Test";
    }

    @Override
    public TypeLabel getFragmentType() {
        return TypeLabel.TEST_MODE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_quiz_test_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.quiz_questions_list);
        recyclerView.setHasFixedSize(true);
        questionsCountText = (TextView) getActivity().findViewById(R.id.statistics_questions_count);
        correctAnswersCountText = (TextView) getActivity().findViewById(R.id.statistics_correct_answers_count);
        bottomNavigation = (BottomNavigationView) getActivity().findViewById(R.id.quiz_resolve_bottom_navigation);

        initializeBottomToolBar();
        refreshView();
        refreshStatisticsSection();
    }

    @Override
    public void refreshStatisticsSection(){

        String questionsInfo = String.valueOf(parent.getStatisticsSumOfQuestions()
                + "/"
                + String.valueOf(parent.getAllQuestions().size()));

        String answersInfo = String.valueOf(parent.getSumOfCorrectAnswers()
                + "/"
                + String.valueOf(parent.getSumOfAnswers()));

        questionsCountText.setText(questionsInfo);
        correctAnswersCountText.setText(answersInfo);
    }

    @Override
    public void refreshDisplayedQuestions() {
        if(questionsAdapter != null){
            questionsAdapter.setQuestionsCollection(parent.getCurrentQuestions());
        }
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
                        parent.getNotDisplayedQuestion();
                        break;
                }
                return true;
            }
        });
    }

    private void refreshView()
    {
        List<QuestionDTO> questions = new ArrayList();
        QuestionDTO q = parent.getNotDisplayedQuestion();
        if(q != null){
            questions.add(q);
            questionsAdapter = new QuizResolveAdapter(questions);
            recyclerView.setAdapter(questionsAdapter);
        }
    }
}
