package com.polsl.easyso.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.items.QuizCategoryViewItem;
import com.polsl.easyso.adapters.items.QuizResolveViewItem;
import com.polsl.easyso.services.dto.QuizCategoryDTO;
import com.polsl.easyso.services.dto.question.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

public class QuizResolveAdapter extends RecyclerView.Adapter<QuizResolveViewItem>{

    private List<QuestionDTO> questionsCollection = new ArrayList<>();

    public QuizResolveAdapter(List<QuestionDTO> questions) {
        questionsCollection = questions;
    }

    @Override
    public QuizResolveViewItem onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Stworzenie nowego calego elementu z listy.
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quiz_resolve_item, parent, false);

        QuizResolveViewItem vh = new QuizResolveViewItem(v);
        vh.setParent(parent);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(QuizResolveViewItem holder, int position) {
        holder.refreshView(questionsCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return questionsCollection.size();
    }
}
