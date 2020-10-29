package com.polsl.easyso.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.polsl.easyso.R;
import com.polsl.easyso.adapters.ScoreAdapter;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.ScoreServices;
import com.polsl.easyso.services.dto.score.ScoreDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        recyclerView = findViewById(R.id.scores_recycler_view);
        recyclerView.setHasFixedSize(true);

        initializeNavigationMenu();

        handleApiCall();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_quiz:
                Intent quiz = new Intent(this, MainActivity.class);
                startActivity(quiz);
                break;
            case R.id.nav_settings:
                Toast.makeText(this, "SETTINGS - TODO!!!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void handleApiCall() {

        ScoreServices call = RetrofitClientFacade.getRetrofitInstance().create(ScoreServices.class);

        Call<List<ScoreDTO>> getAllScores = call.getAllScores();
        getAllScores.enqueue(new Callback<List<ScoreDTO>>() {
            @Override
            public void onResponse(Call<List<ScoreDTO>> call, Response<List<ScoreDTO>> response) {
                handleResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<ScoreDTO>> call, Throwable t) {
                Toast.makeText(ScoreBoardActivity.this,
                        "Failed to fetch data. Check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void handleResponse(List<ScoreDTO> body) {
        adapter = new ScoreAdapter(body);
        recyclerView.setAdapter(adapter);
    }

    private void initializeNavigationMenu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_open);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
}