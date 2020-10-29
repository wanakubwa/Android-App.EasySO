package com.polsl.easyso.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.items.QuizCategoryViewItem;
import com.polsl.easyso.adapters.items.ScoreViewItem;
import com.polsl.easyso.services.dto.QuizCategoryDTO;
import com.polsl.easyso.services.dto.score.ScoreDTO;

import java.util.ArrayList;
import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreViewItem>{

    private List<ScoreDTO> scoreCollection = new ArrayList<>();

    public ScoreAdapter(List<ScoreDTO> scoreCollection) {
        this.scoreCollection = scoreCollection;
    }

    @Override
    public ScoreViewItem onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Stworzenie nowego calego elementu z listy.
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scores_item, parent, false);

        ScoreViewItem vh = new ScoreViewItem(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ScoreViewItem holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.refreshView(scoreCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return scoreCollection.size();
    }
}