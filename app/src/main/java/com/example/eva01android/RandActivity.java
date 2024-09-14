package com.example.eva01android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.rand_num);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRand), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random rand = new Random();
        EditText txt_minNum = findViewById(R.id.txt_minNum);
        EditText txt_maxNum = findViewById(R.id.txt_maxNum);
        TextView txtv_ranNum = findViewById(R.id.txtv_randNum);
        Button btn_getRan = findViewById(R.id.btn_getRan);

        btn_getRan.setOnClickListener(view -> {
            try{
                int minNum = Integer.parseInt(txt_minNum.getText().toString().trim());
                int maxNum = Integer.parseInt(txt_maxNum.getText().toString().trim());
                if (txt_minNum.getText().toString().isEmpty() || txt_maxNum.getText().toString().isEmpty() || minNum > maxNum){
                    txtv_ranNum.setText("Ha ocurrido un error, verifique los datos ingresados.");
                    Toast.makeText(this, "bwomp :(", Toast.LENGTH_SHORT).show();
                } else {
                    String ranNum = String.valueOf(rand.nextInt(maxNum - minNum + 1) + minNum);
                    txtv_ranNum.setText("Su número es: " + ranNum);
                    Toast.makeText(this, ":D!", Toast.LENGTH_SHORT).show();
                }
            }catch (NumberFormatException e){
                Toast.makeText(this, "bwomp :(", Toast.LENGTH_SHORT).show();
                txtv_ranNum.setText("Porfavor, ingrese números enteros");
                return;
            }

        });
    }
}