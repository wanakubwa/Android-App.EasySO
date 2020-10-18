package com.polsl.easyso.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.items.QuizTopicViewItem;
import com.polsl.easyso.services.dto.QuestionTopicDTO;

import java.util.ArrayList;
import java.util.List;

public class QuizTopicAdapter extends RecyclerView.Adapter<QuizTopicViewItem>{

    private List<QuestionTopicDTO> questionsTopicsCollection = new ArrayList<>();

    public QuizTopicAdapter(List<QuestionTopicDTO> topics) {
        questionsTopicsCollection = topics;
    }

    @Override
    public QuizTopicViewItem onCreateViewHolder(ViewGroup parent, int viewType) {

        // Stworzenie nowego calego elementu z listy.
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quiz_topic_list_item, parent, false);

        QuizTopicViewItem vh = new QuizTopicViewItem(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(QuizTopicViewItem holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.refreshView(questionsTopicsCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return questionsTopicsCollection.size();
    }

}
