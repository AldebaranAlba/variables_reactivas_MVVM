package com.example.variables_reactivas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import viewmodel.ContadorViewModel;

public class MainActivity extends AppCompatActivity {
    private ContadorViewModel contadorViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView txtContador = findViewById(R.id.txtContador);
        Button btnIncrementar = findViewById(R.id.btnIncrementar);


        contadorViewModel = new ViewModelProvider(this).get(ContadorViewModel.class);

        // CADA VEZ QUE SE PRESIONA EL BOTON, SE INCREMENTA EL CONTADOR
        btnIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorViewModel.incrementarContador();
            }
        });

        // OBSERVA CUANDO LIVEDATA CAMBIA AL INCREMENTAR EL CONTADOR ESTE ACTUALIZA EL TXT
        contadorViewModel.getContador().observe(this, valor -> {
            // ACTUALIZA CADA VEZ QUE EL CONTADOR CAMBIE
            txtContador.setText(String.valueOf(valor));
        });


    }
}