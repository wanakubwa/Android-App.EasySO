package com.polsl.easyso.adapters.items;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polsl.easyso.R;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

// Klasa zawierajaca przepis na stworzenie jednego elementu na widoku w liscie.
public class QuizCategoryViewItem extends RecyclerView.ViewHolder {

    private View cachedViewElement;

    private QuizCategoryDTO cachedQuizCategory;
    private TextView textView;

    public QuizCategoryViewItem(@NonNull View currentViewElement) {
        super(currentViewElement);

        cachedViewElement = currentViewElement;
        refrehViewElements();
    }

    public void refresh(@NonNull QuizCategoryDTO currentQuizCategory)
    {
        cachedQuizCategory = currentQuizCategory;
        textView.setText(currentQuizCategory.getName());
    }

    private void refrehViewElements()
    {
        textView = (TextView) cachedViewElement.findViewById(R.id.quiz_category_item_text_view);
    }
}
