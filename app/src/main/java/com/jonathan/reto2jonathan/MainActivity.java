package com.jonathan.reto2jonathan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        google = findViewById(R.id.textView2);
        google.setText(getText(R.string.google));
    }

    public void Dashboard(View view) {
        displayToast("Ha seleccionado el boton ingreso");
        startActivity(new Intent(MainActivity.this,Dashboard.class));

    }
    public void displayToast(String message) {
        Toast.makeText(MainActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }
}
