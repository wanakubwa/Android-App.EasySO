package com.polsl.easyso.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.QuizCategoryAdapter;
import com.polsl.easyso.constants.Constants;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuizCategoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    private RecyclerView recyclerView;
    private DrawerLayout drawerLayout;

    public static MainActivity getInstance() {
        return instance;
    }

    public void onQuizCategoryClicked(@NonNull QuizCategoryDTO quizCategoryItem) {
        Intent intent = new Intent(this, TopicsActivity.class);
        intent.putExtra(Constants.QUIZ_CATEGORY_INTENT_NAME, quizCategoryItem);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        initializeNavigationMenu();

        recyclerView = (RecyclerView) findViewById(R.id.quizzes_labels_recycle_view);
        recyclerView.setHasFixedSize(true);

        InitializeQuizzesCategoriesView();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initializeNavigationMenu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_open);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void InitializeQuizzesCategoriesView() {
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

        // Tworzenie adaptera.
        QuizCategoryAdapter quizCategoryAdapter = new QuizCategoryAdapter(quizesList);
        recyclerView.setAdapter(quizCategoryAdapter);
    }
}
