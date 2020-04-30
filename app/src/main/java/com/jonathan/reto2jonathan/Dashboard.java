package com.jonathan.reto2jonathan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

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
                    displayToast("Menu For You");
                    break;
                case R.id.nav_headlines:
                    selectedFragment = new HeadLines();
                    displayToast("Menu HeadLines");
                    break;
                case R.id.nav_fav:
                    selectedFragment = new Favourites();
                    displayToast("Menu Favourites");
                    break;
                case R.id.nav_newsstand:
                    selectedFragment = new NewsStand();
                    displayToast("Menu Newsstand");
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}
