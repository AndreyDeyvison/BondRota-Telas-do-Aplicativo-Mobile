package com.andreydeyvison.bondrota;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imagemLogo;

    static final int DELAY_TIME = 5000;

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


        imagemLogo = findViewById(R.id.imagemLogo);

        imagemLogo.setTranslationY(3000);

        imagemLogo.animate().translationY(0).setDuration(500).setStartDelay(100).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent para iniciar a próxima Activity
                Intent intent = new Intent(MainActivity.this, TelaLogin.class);
                startActivity(intent);
                finish(); // Finaliza a Activity atual para não voltar a ela
            }
        }, DELAY_TIME);

    }
}