package com.polsl.easyso.adapters.items;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.activities.MainActivity;
import com.polsl.easyso.R;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

// Klasa zawierajaca przepis na stworzenie jednego elementu na widoku w liscie.
public class QuizCategoryViewItem extends RecyclerView.ViewHolder {

    private QuizCategoryDTO cachedQuizCategory;

    private TextView quizCategoryLabelText;
    private TextView quizCountText;

    public QuizCategoryViewItem(@NonNull View currentViewElement) {
        super(currentViewElement);

        refreshViewFields();
    }

    public void refreshView(@NonNull QuizCategoryDTO currentQuizCategory)
    {
        cachedQuizCategory = currentQuizCategory;

        quizCategoryLabelText.setText(currentQuizCategory.getName());
        quizCountText.setText(currentQuizCategory.getQuizezCount().toString());
    }

    private void refreshViewFields()
    {
        quizCategoryLabelText = (TextView) itemView.findViewById(R.id.quiz_category_item_label);
        quizCountText = (TextView) itemView.findViewById(R.id.quiz_category_item_count);

        itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.getInstace().onQuizCategoryClicked(cachedQuizCategory);
            }
        });
    }
}
