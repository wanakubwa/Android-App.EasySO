package com.polsl.easyso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuizServices retrofitClient = RetrofitClientFacade.getRetrofitInstance().create(QuizServices.class);

        System.out.println("xd-start");
        Call<List<QuizCategoryDTO>> catogoriesCall = retrofitClient.getQuizzesCategories();
        catogoriesCall.enqueue(new Callback<List<QuizCategoryDTO>>() {

            @Override
            public void onResponse(Call<List<QuizCategoryDTO>> call, Response<List<QuizCategoryDTO>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<QuizCategoryDTO>> call, Throwable throwable) {
                //Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
                System.out.println("Failure!");
            }
        });
    }

    private void loadDataList(List<QuizCategoryDTO> quizesList) {
        //todo;

        for (QuizCategoryDTO q: quizesList) {
            System.out.println(q.getName() + " " + q.getQuizezCount());
        }
    }
}
