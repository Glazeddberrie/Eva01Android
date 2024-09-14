package com.example.eva01android;

import android.content.Intent;
import android.os.Bundle;
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
        Button btn_randNum = findViewById(R.id.btn_rand);
        Button btn_valRut = findViewById(R.id.btn_valRut);

        btn_randNum.setOnClickListener(view -> {
            Intent intent = new Intent(this, RandActivity.class);
            startActivity(intent);
        });

        btn_valRut.setOnClickListener(view -> {
            Intent intent = new Intent(this, RutActivity.class);
            startActivity(intent);
        });
    }
}