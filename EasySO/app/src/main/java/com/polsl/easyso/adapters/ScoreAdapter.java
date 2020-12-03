package com.polsl.easyso.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.items.QuizCategoryViewItem;
import com.polsl.easyso.adapters.items.ScoreViewItem;
import com.polsl.easyso.services.dto.QuizCategoryDTO;
import com.polsl.easyso.services.dto.score.ScoreDTO;

import java.util.ArrayList;
import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreViewItem> implements Filterable {

    private List<ScoreDTO> scoreCollection;
    private List<ScoreDTO> scoreCollectionFull = new ArrayList<>();

    public ScoreAdapter(List<ScoreDTO> scoreCollection) {
        this.scoreCollection = scoreCollection;
        this.scoreCollectionFull = new ArrayList<>(scoreCollection);
    }

    @Override
    public ScoreViewItem onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        // Stworzenie nowego calego elementu z listy.
        View v = LayoutInflater.from(parent.getContext())
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

    @Override
    public Filter getFilter() {
        return scoreFilter;
    }

    private Filter scoreFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ScoreDTO> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(scoreCollectionFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ScoreDTO score : scoreCollectionFull) {
                    if (score.getUsername().toLowerCase().contains(filterPattern)) {
                        filteredList.add(score);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            scoreCollection.clear();
            scoreCollection.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}