package com.laioffer.tinnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.network.NewsApi;
import com.laioffer.tinnews.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//view layer

public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        //link bottomview with navigationonContainerView
        NavigationUI.setupWithNavController(navView, navController);
        //link the actionbar with navigationonContainerView
        NavigationUI.setupActionBarWithNavController(this, navController);

        //network request and print in onCreate.
        //moved to model layer



    }

    //Overriding onSupportNavigateUp is for handling the top left back button.
    // Notice the title bar also changes with bottom navigation.
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }


}