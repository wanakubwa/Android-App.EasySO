package com.polsl.easyso.adapters.items;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Klasa zawierajaca przepis na stworzenie jednego elementu na widoku w liscie.
public class QuizCategoryViewItem extends RecyclerView.ViewHolder {

    public TextView textView;

    public QuizCategoryViewItem(@NonNull TextView view) {
        super(view);

        textView = view;
    }
}
