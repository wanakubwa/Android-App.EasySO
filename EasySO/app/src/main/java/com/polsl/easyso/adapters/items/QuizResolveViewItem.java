package com.polsl.easyso.adapters.items;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.CompoundButtonCompat;
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
        QuizResolveActivity.getInstance().onAnswerSelected(cachedQuestion.getId(), answerId);
    }

    private void refreshViewFields()
    {
        questionText = (TextView) itemView.findViewById(R.id.question_label);
        answersParent = (LinearLayout) itemView.findViewById(R.id.question_answers_parent);
    }

    private void createAnswersViewCollection()
    {
        refreshAnswersCollection();

        for(int i =0; i < cachedQuestion.getAnswers().size(); i++) {
            answersViewCollection.get(i).refreshView(cachedQuestion.getAnswers().get(i));
        }
    }

    private void refreshAnswersCollection() {
        if(answersViewCollection.size() < 1){
            initializeAnswersCollection();
            return;
        }

        int answersDelta = answersViewCollection.size() - cachedQuestion.getAnswers().size();
        if(answersDelta > 0) {
            int cachedViewCollectionSize = answersViewCollection.size();
            for(int i = answersViewCollection.size() -1; i >= cachedViewCollectionSize - answersDelta; i-- ) {
                answersParent.removeViewAt(i);
                answersViewCollection.remove(i);
            }
        }
        else if (answersDelta < 0){
            answersDelta = answersDelta * -1;

            for(int i=0; i < answersDelta; i++){
                View v =  LayoutInflater.from(itemView.getContext())
                        .inflate(R.layout.quiz_resolve_answer_element, parent, false);

                answersParent.addView(v);
                answersViewCollection.add(new AnswerViewItem(v, this));
            }
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

        private View answerViewItem;
        private OnAnswerSelectedCallback answerSelectedCallback;
        private AnswerDTO cachedAnswer;

        private TextView answerLabel;
        private LinearLayout answerParent;
        private CheckBox answerCheckBox;

        public AnswerViewItem(View answerViewItem, OnAnswerSelectedCallback answerSelectedCallback) {
            this.answerViewItem = answerViewItem;
            this.answerSelectedCallback = answerSelectedCallback;

            bindViewFields();
        }

        public AnswerViewItem(View answerViewItem, OnAnswerSelectedCallback answerSelectedCallback, AnswerDTO cachedAnswer) {
            this.answerViewItem = answerViewItem;
            this.answerSelectedCallback = answerSelectedCallback;
            this.cachedAnswer = cachedAnswer;

            bindViewFields();
        }

        public void setAnswerViewItem(View answerViewItem) {
            this.answerViewItem = answerViewItem;
        }

        public void setAnswerSelectedCallback(OnAnswerSelectedCallback answerSelectedCallback) {
            this.answerSelectedCallback = answerSelectedCallback;
        }

        public void setCachedAnswer(AnswerDTO cachedAnswer) {
            this.cachedAnswer = cachedAnswer;
        }

        public void refreshView(AnswerDTO answer) {
            setCachedAnswer(answer);

            refreshStateVisualization();

            answerLabel.setText(cachedAnswer.getAnswerText().trim());
            answerParent.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onAnswerSelectedHandler(cachedAnswer.getId());
                }
            });
        }

        private void refreshStateVisualization() {
            answerCheckBox.setChecked(cachedAnswer.getIsUserSelect());

            switch(cachedAnswer.getCurrentStatus()){
                case CORRECT:
                    setCorrectState();
                    break;
                case INCORRECT:
                    setInCorrectState();
                    break;
                    default:
                        setDefaultState();
                        break;
            }
        }

        private void setDefaultState(){
            answerLabel.setTextColor(QuizResolveActivity.getInstance().getColor(R.color.colorText));
        }

        private void setCorrectState(){
            answerLabel.setTextColor(QuizResolveActivity.getInstance().getColor(R.color.colorPositiveAccent));
        }

        private void setInCorrectState(){
            answerLabel.setTextColor(QuizResolveActivity.getInstance().getColor(R.color.colorAccent));
        }

        private void bindViewFields()
        {
            answerLabel = (TextView) answerViewItem.findViewById(R.id.answer_label_text);
            answerParent = (LinearLayout) answerViewItem.findViewById(R.id.answer_element_parent);
            answerCheckBox = (CheckBox) answerViewItem.findViewById(R.id.answer_check_box);
        }
    }
}
