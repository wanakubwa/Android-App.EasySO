package com.polsl.easyso.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.items.QuizCategoryViewItem;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class QuizCategoryAdapter extends RecyclerView.Adapter<QuizCategoryViewItem>{

    private List<QuizCategoryDTO> quizzesCollection = new ArrayList<>();

    public QuizCategoryAdapter(List<QuizCategoryDTO> quizzesCategoryInfoCollection) {
        quizzesCollection = quizzesCategoryInfoCollection;
    }

    @Override
    public QuizCategoryViewItem onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Stworzenie nowego calego elementu z listy.
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quiz_category_list_item, parent, false);

        QuizCategoryViewItem vh = new QuizCategoryViewItem(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(QuizCategoryViewItem holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.refresh(quizzesCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return quizzesCollection.size();
    }
}
