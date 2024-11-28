package com.siddhantbhardwaj.androidintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
            Intents: facilitates communication between, different components of an app,
            as well as between different applications.

            types of intent:
                1. Explicit Intent
                2. Implicit Intent
         */

        // Explicit Intent Between 2 components of the same app
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });

        // Implicit Intent - Triggers Components of Other Apps
        Button btnTwo = findViewById(R.id.button2);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage();
            }
        });
    }

    public void goToSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    public void openWebPage(){
        Uri webpage = Uri.parse("https://www.google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(intent);
    }
}