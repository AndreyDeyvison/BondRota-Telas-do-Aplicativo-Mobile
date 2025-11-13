package com.andreydeyvison.bondrota;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class TelaLogin extends AppCompatActivity {



    TextView telaBranca;
    ImageView nuvemAzulClaro,nuvemAzulEscuro,nuvemBranca,onibus;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;

        });

        telaBranca = findViewById(R.id.tela_branca);

        telaBranca.setAlpha(1);
        telaBranca.animate().alpha(0).setDuration(700).start();

        nuvemAzulEscuro = findViewById(R.id.nuvemAzulEscuro);
        nuvemAzulClaro = findViewById(R.id.nuvemAzulClaro);
        nuvemBranca = findViewById(R.id.nuvemBranca);
        onibus = findViewById(R.id.onibus);

        onibus.setTranslationX(1000);
        onibus.animate().translationX(0).setDuration(700).start();

        nuvemBranca.setTranslationX(1500);
        nuvemBranca.animate().translationX(0).setDuration(1000).start();

        nuvemAzulEscuro.setTranslationX(-1500);
        nuvemAzulEscuro.animate().translationX(0).setDuration(1000).setStartDelay(200).start();

        nuvemAzulClaro.setTranslationX(1500);
        nuvemAzulClaro.animate().translationX(0).setDuration(1000).setStartDelay(400).start();


        AppCompatButton botaoLogin = findViewById(R.id.botaoLogin);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this, TelaApp.class);
                startActivity(intent);
                finish();
            }
        });



    }
}