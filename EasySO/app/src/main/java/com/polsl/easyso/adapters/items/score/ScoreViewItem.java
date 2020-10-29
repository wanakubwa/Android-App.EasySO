package com.polsl.easyso.adapters.items;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.activities.MainActivity;
import com.polsl.easyso.R;
import com.polsl.easyso.activities.TopicsActivity;
import com.polsl.easyso.services.dto.QuizCategoryDTO;
import com.polsl.easyso.services.dto.score.ScoreDTO;

// Klasa zawierajaca przepis na stworzenie jednego elementu na widoku w liscie.
public class ScoreViewItem extends RecyclerView.ViewHolder {

    private ScoreDTO scoreDTO;

    private TextView username;
    private TextView score;

    public ScoreViewItem(@NonNull View currentViewElement) {
        super(currentViewElement);

        refreshViewFields();
    }

    public void refreshView(@NonNull ScoreDTO currentScore)
    {
        scoreDTO = currentScore;

        username.setText(currentScore.getUsername());
        score.setText(currentScore.getScore().toString());
    }

    private void refreshViewFields()
    {
        username = (TextView) itemView.findViewById(R.id.scores_username);
        score = (TextView) itemView.findViewById(R.id.scores_score);

        /*itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.getInstance().onQuizCategoryClicked(scoreDTO);
            }
        });*/
    }
}
