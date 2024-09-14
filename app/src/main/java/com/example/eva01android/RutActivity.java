package com.example.eva01android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RutActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calc_rut);
        EditText rutGotten = findViewById(R.id.txt_rutInput);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRut), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_validate = findViewById(R.id.btn_validateRut);
        ImageView imageView = findViewById(R.id.confirmImage);
        TextView textView = findViewById(R.id.txtv_confirmation);

        btn_validate.setOnClickListener(view -> {
            validation();

            if (validation() == true){
                imageView.setImageResource(R.drawable.thumbs_up);
                textView.setText("RUT Validado Con Exito!");
                Toast.makeText(this, ":D!", Toast.LENGTH_SHORT).show();
            } else {
                imageView.setImageResource(R.drawable.soggy);
                textView.setText("No se pudo validar el Rut.");
                Toast.makeText(this, "bwomp :(", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validation (){

        boolean siono = false;
        EditText rutGotten = findViewById(R.id.txt_rutInput);
        String rut = rutGotten.getText().toString().trim().toUpperCase().replace(".", "").replace("-", "").replace("K","0");

        //Esta operación la rescaté de Stackoverflow y la optimizé un poquitin xd.
        //https://es.stackoverflow.com/a/156485
        try {
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                siono = true;

            }

        } catch (java.lang.NumberFormatException e) {

        } catch (Exception e) {

        }
        return  siono;
    }
}