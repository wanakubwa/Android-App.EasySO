package com.polsl.easyso.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.items.QuizResolveLearnViewItem;
import com.polsl.easyso.adapters.items.QuizResolveViewItem;
import com.polsl.easyso.services.dto.question.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

public class QuizResolveLearnAdapter extends RecyclerView.Adapter<QuizResolveLearnViewItem> {

    private List<QuestionDTO> questionsCollection = new ArrayList<>();

    public QuizResolveLearnAdapter(List<QuestionDTO> questions) {
        questionsCollection = questions;
    }

    public void setQuestionsCollection(List<QuestionDTO> questionsCollection) {
        this.questionsCollection = questionsCollection;
        notifyDataSetChanged();
    }

    @Override
    public QuizResolveLearnViewItem onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        // Stworzenie nowego calego elementu z listy.
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quiz_resolve_item, parent, false);

        QuizResolveLearnViewItem vh = new QuizResolveLearnViewItem(v);
        vh.setParent(parent);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(QuizResolveLearnViewItem holder, int position) {
        holder.refreshView(questionsCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return questionsCollection.size();
    }
}
