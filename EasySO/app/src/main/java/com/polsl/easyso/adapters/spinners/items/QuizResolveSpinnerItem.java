package com.polsl.easyso.adapters.spinners.items;

import com.polsl.easyso.activities.resolveActivity.fragments.QuizResolveFragmentBase;

public class QuizResolveSpinnerItem {

    private String infoText;
    private QuizResolveFragmentBase.TypeLabel fragmentTypeLabel;

    public QuizResolveSpinnerItem(String infoText, QuizResolveFragmentBase.TypeLabel fragmentTypeLabel) {
        this.infoText = infoText;
        this.fragmentTypeLabel = fragmentTypeLabel;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public QuizResolveFragmentBase.TypeLabel getFragmentTypeLabel() {
        return fragmentTypeLabel;
    }

    public void setFragmentTypeLabel(QuizResolveFragmentBase.TypeLabel fragmentTypeLabel) {
        this.fragmentTypeLabel = fragmentTypeLabel;
    }
}
