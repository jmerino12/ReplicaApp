package com.jonathan.reto2jonathan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jonathan.reto2jonathan.ui.Favourites;
import com.jonathan.reto2jonathan.ui.ForYou;
import com.jonathan.reto2jonathan.ui.HeadLines;
import com.jonathan.reto2jonathan.ui.NewsStand;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ForYou()).commit();
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_me:
                    selectedFragment = new ForYou();
                    break;
                case R.id.nav_headlines:
                    selectedFragment = new HeadLines();
                    break;
                case R.id.nav_fav:
                    selectedFragment = new Favourites();
                    break;
                case R.id.nav_newsstand:
                    selectedFragment = new NewsStand();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
}
