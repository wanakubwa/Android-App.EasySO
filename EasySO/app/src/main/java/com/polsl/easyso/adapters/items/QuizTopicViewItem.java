package com.polsl.easyso.adapters.items;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.activities.TopicsActivity;
import com.polsl.easyso.services.dto.QuestionTopicDTO;

public class QuizTopicViewItem extends RecyclerView.ViewHolder {

    private QuestionTopicDTO cachedQuestionTopic;

    private TextView questionTopicLabelText;
    private TextView questionsCountText;

    public QuizTopicViewItem(@NonNull View currentViewElement) {
        super(currentViewElement);

        refreshViewFields();
    }

    public void refreshView(@NonNull QuestionTopicDTO currentQuestionTopic) {
        cachedQuestionTopic = currentQuestionTopic;

        questionTopicLabelText.setText(cachedQuestionTopic.getLabel());
        setQuestionsCountText(cachedQuestionTopic.getQuestionsCount());
    }

    private void refreshViewFields()
    {
        questionTopicLabelText = (TextView) itemView.findViewById(R.id.list_item_topic_label);
        questionsCountText = (TextView) itemView.findViewById(R.id.quiz_topic_questions_count);

        itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TopicsActivity.getInstance().onTopicClicked(cachedQuestionTopic);
            }
        });
    }

    private void setQuestionsCountText(int questionsCount)
    {
        questionsCountText.setText(String.valueOf(questionsCount));

        if(questionsCount < 1)
        {
             questionsCountText.setTextColor(TopicsActivity.getInstance().getColor(R.color.colorAccent));
        }
        else
        {
           questionsCountText.setTextColor(TopicsActivity.getInstance().getColor(R.color.colorPositiveAccent));
        }
    }
}
