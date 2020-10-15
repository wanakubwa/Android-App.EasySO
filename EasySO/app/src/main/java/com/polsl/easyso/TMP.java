package com.polsl.easyso;

import android.widget.Toast;

import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TMP {

    public static void main(String[] args) {
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

    private static void loadDataList(List<QuizCategoryDTO> quizesList) {
        //todo;

        for (QuizCategoryDTO q: quizesList) {
            System.out.println(q.getName() + " " + q.getQuizezCount());
        }
    }
}
