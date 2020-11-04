package com.polsl.easyso.adapters.spinners;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.polsl.easyso.adapters.spinners.items.QuizResolveSpinnerItem;

public class QuizResolveSpinnerAdapter extends ArrayAdapter<QuizResolveSpinnerItem> {

    private Context context;
    private QuizResolveSpinnerItem[] values;

    public QuizResolveSpinnerAdapter(Context context, int textViewResourceId,
                                     QuizResolveSpinnerItem[] values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount(){
        return values.length;
    }

    @Override
    public QuizResolveSpinnerItem getItem(int position){
        return values[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values[position].getInfoText());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values[position].getInfoText());

        return label;
    }
}
