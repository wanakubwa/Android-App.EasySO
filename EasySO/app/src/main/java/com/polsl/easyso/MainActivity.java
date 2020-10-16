package com.polsl.easyso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.polsl.easyso.adapters.QuizCategoryAdapter;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.quizzes_labels_recycle_view);
        recyclerView.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        InitializeQuizzesCategoriesView();
    }

    private void InitializeQuizzesCategoriesView()
    {
        QuizServices retrofitClient = RetrofitClientFacade.getRetrofitInstance().create(QuizServices.class);

        Call<List<QuizCategoryDTO>> allCategories = retrofitClient.getQuizzesCategories();
        allCategories.enqueue(new Callback<List<QuizCategoryDTO>>() {

            @Override
            public void onResponse(Call<List<QuizCategoryDTO>> call, Response<List<QuizCategoryDTO>> response) {
                loadDataList(response.body());
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<QuizCategoryDTO>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Unable to load ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadDataList(List<QuizCategoryDTO> quizesList) {

        for(int i =0; i < 50; i++)
        {
            quizesList.add((new QuizCategoryDTO("Kat: " + i, 1)));
        }

        // Tworzenie adaptera.
        QuizCategoryAdapter quizCategoryAdapter = new QuizCategoryAdapter(quizesList);
        recyclerView.setAdapter(quizCategoryAdapter);
    }
}
