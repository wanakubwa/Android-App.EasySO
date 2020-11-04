package com.polsl.easyso.activities.resolveActivity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.polsl.easyso.R;
import com.polsl.easyso.adapters.QuizResolveAdapter;
import com.polsl.easyso.adapters.QuizResolveLearnAdapter;

public class QuizLearnFragment extends QuizResolveFragmentBase {

    private RecyclerView recyclerView;
    private QuizResolveLearnAdapter questionsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quiz_learn_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.quiz_learn_questions_list);
        recyclerView.setHasFixedSize(true);

        refreshView();
    }

    @Override
    public String getOptionName() {
        return "Nauka";
    }

    @Override
    public TypeLabel getFragmentType() {
        return TypeLabel.LEARN_MODE;
    }

    private void refreshView()
    {
        questionsAdapter = new QuizResolveLearnAdapter(parent.getAllQuestions());
        recyclerView.setAdapter(questionsAdapter);
    }
}
