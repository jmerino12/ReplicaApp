package com.jonathan.reto2jonathan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jonathan.reto2jonathan.ui.HeadLines;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HeadLines()).commit();
    }
}
