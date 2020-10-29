package com.polsl.easyso.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.polsl.easyso.R;
import com.polsl.easyso.activities.TopicsActivity;
import com.polsl.easyso.activities.resolveActivity.QuizResolveActivity;

public class StatisticsSendPopUpDialog extends Dialog {

    private Button acceptButton;
    private Button cancelButton;
    private EditText nickNameInputField;
    private TextView scoreValueText;

    public StatisticsSendPopUpDialog(Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_statistics_send_dialog);

        acceptButton = (Button) findViewById(R.id.popup_statistics_accept_btn);
        cancelButton = (Button) findViewById(R.id.popup_statistics_discard_btn);
        nickNameInputField = (EditText) findViewById(R.id.popup_statistics_edit_text);
        scoreValueText = (TextView)findViewById(R.id.popup_statistics_score_value);

        initializeListeners();
        refreshView();
    }

    private void refreshView(){
        scoreValueText.setText(String.valueOf(QuizResolveActivity.getInstance().getScoreValue()));
    }

    private void initializeListeners(){

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAcceptHandler();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDiscardHandler();
            }
        });
    }

    private void onDiscardHandler(){
        QuizResolveActivity.getInstance().finish();
    }

    private void onAcceptHandler(){
        //todo;

        String name = nickNameInputField.getText().toString();
        if(name.isEmpty() == true){
            Toast.makeText(getContext(), R.string.popup_statistics_empty_nick_alert, Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getContext(), nickNameInputField.getText(), Toast.LENGTH_SHORT).show();
        onDiscardHandler();
    }
}
