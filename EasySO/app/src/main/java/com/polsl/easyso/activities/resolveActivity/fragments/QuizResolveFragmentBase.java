package com.polsl.easyso.activities.resolveActivity.fragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.polsl.easyso.activities.resolveActivity.QuizResolveActivity;

public abstract class QuizResolveFragmentBase extends Fragment {

    protected QuizResolveActivity parent;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        setParentActivity((QuizResolveActivity) context);
    }

    public void refreshDisplayedQuestions(){

    }

    public void refreshStatisticsSection(){

    }

    public abstract String getOptionName();

    public abstract TypeLabel getFragmentType();

    private void setParentActivity(QuizResolveActivity parent){
        this.parent = parent;
    }

    public enum TypeLabel {
        RANDOM_MODE,
        LEARN_MODE,
        TEST_MODE
    }
}
