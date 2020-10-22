package com.polsl.easyso.adapters.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.activities.TopicsActivity;
import com.polsl.easyso.activities.resolveActivity.QuizResolveActivity;
import com.polsl.easyso.adapters.callbacks.OnAnswerSelectedCallback;
import com.polsl.easyso.services.dto.question.AnswerDTO;
import com.polsl.easyso.services.dto.question.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

public class QuizResolveViewItem extends RecyclerView.ViewHolder implements OnAnswerSelectedCallback {

    private QuestionDTO cachedQuestion;

    private TextView questionText;
    private LinearLayout answersParent;
    private List<AnswerViewItem> answersViewCollection = new ArrayList<>();
    private ViewGroup parent;

    public QuizResolveViewItem(@NonNull View currentViewElement) {
        super(currentViewElement);

        refreshViewFields();
    }

    public void setParent(ViewGroup parent) {
        this.parent = parent;
    }

    public QuestionDTO getCachedQuestion() {
        return cachedQuestion;
    }

    public void setCachedQuestion(QuestionDTO cachedQuestion) {
        this.cachedQuestion = cachedQuestion;
    }

    public void refreshView(@NonNull QuestionDTO currentQuestion) {
        setCachedQuestion(currentQuestion);

        questionText.setText(cachedQuestion.getQuestionText());
        createAnswersViewCollection();
    }

    @Override
    public void onAnswerSelectedHandler(int answerId) {
        //todo;
    }

    private void refreshViewFields()
    {
        questionText = (TextView) itemView.findViewById(R.id.question_label);
        answersParent = (LinearLayout) itemView.findViewById(R.id.question_answers_parent);
    }

    private void createAnswersViewCollection()
    {
        if(answersViewCollection.size() <1){
            initializeAnswersCollection();
        }

        for(int i =0; i < cachedQuestion.getAnswers().size(); i++) {
            answersViewCollection.get(i).refreshView(cachedQuestion.getAnswers().get(i));
        }
    }

    private void initializeAnswersCollection()
    {
        for(AnswerDTO answer : cachedQuestion.getAnswers()){
            View v =  LayoutInflater.from(itemView.getContext())
                    .inflate(R.layout.quiz_resolve_answer_element, parent, false);

            answersParent.addView(v);
            answersViewCollection.add(new AnswerViewItem(v, this, answer));
        }
    }

    public class AnswerViewItem {

        private View viewItem;
        private OnAnswerSelectedCallback answerSelectedCallback;
        private AnswerDTO cachedAnswer;

        private TextView answerLabel;
        private LinearLayout answerParent;

        public AnswerViewItem(View viewItem, OnAnswerSelectedCallback answerSelectedCallback, AnswerDTO cachedAnswer) {
            this.viewItem = viewItem;
            this.answerSelectedCallback = answerSelectedCallback;
            this.cachedAnswer = cachedAnswer;

            bindViewFields();
        }

        public void setViewItem(View viewItem) {
            this.viewItem = viewItem;
        }

        public void setAnswerSelectedCallback(OnAnswerSelectedCallback answerSelectedCallback) {
            this.answerSelectedCallback = answerSelectedCallback;
        }

        public void setCachedAnswer(AnswerDTO cachedAnswer) {
            this.cachedAnswer = cachedAnswer;
        }

        public void refreshView(AnswerDTO answer) {
            setCachedAnswer(answer);

            answerLabel.setText(cachedAnswer.getAnswerText().trim());

            answerParent.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onAnswerSelectedHandler(cachedAnswer.getId());
                }
            });
        }

        private void bindViewFields()
        {
            answerLabel = (TextView) viewItem.findViewById(R.id.answer_label_text);
            answerParent = (LinearLayout) viewItem.findViewById(R.id.answer_element_parent);
        }
    }
}
