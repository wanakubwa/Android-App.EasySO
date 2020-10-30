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
import com.polsl.easyso.activities.MainActivity;
import com.polsl.easyso.activities.TopicsActivity;
import com.polsl.easyso.activities.resolveActivity.QuizResolveActivity;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.score.ScorePostDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        String name = nickNameInputField.getText().toString();
        if(name.isEmpty() == true){
            Toast.makeText(getContext(), R.string.popup_statistics_empty_nick_alert, Toast.LENGTH_SHORT).show();
            return;
        }

        ScorePostDTO scorePostDTO = new ScorePostDTO(nickNameInputField.getText().toString(), QuizResolveActivity.getInstance().getScoreValue(), Constants.APPLICATION_WEB_SERVICE_KEY);
        RetrofitClientFacade.getRetrofitInstance().create(QuizServices.class).setScore(scorePostDTO).enqueue(new Callback<ScorePostDTO>() {
            @Override
            public void onResponse(Call<ScorePostDTO> call, Response<ScorePostDTO> response) {

                if(response.isSuccessful()) {
                    onDiscardHandler();
                }
            }

            @Override
            public void onFailure(Call<ScorePostDTO> call, Throwable t) {
                onDiscardHandler();
            }
        });
    }
}
