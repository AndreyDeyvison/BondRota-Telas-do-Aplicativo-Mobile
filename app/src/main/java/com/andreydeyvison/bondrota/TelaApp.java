package com.andreydeyvison.bondrota;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TelaApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mudarFragmento(new FragmentViagens());

        BottomNavigationView menu = findViewById(R.id.menuInferior);
        menu.setItemBackground(null);
        menu.setItemActiveIndicatorEnabled(false);


        menu.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.viagens) {
                mudarFragmento(new FragmentViagens());
            } else if (itemId == R.id.notifica) {
                mudarFragmento(new FragmentNotificacoes());
            }

            return true;
        });


        FloatingActionButton floatButton = findViewById(R.id.fabPerfil);
        floatButton.setOnClickListener(view -> {
            mudarFragmento(new FragmentPerfil());
        });


    }

    public void configurarBotaoDoFragment() {
        // Encontrar o fragment pelo tag
        Fragment fragmentAtual = getSupportFragmentManager()
                .findFragmentByTag("current_fragment");

        // Verificar se é o FragmentViagens E se a view já foi criada
        if (fragmentAtual instanceof FragmentViagens && fragmentAtual.getView() != null) {
            FragmentViagens fragmentRegistrarViagem = (FragmentViagens) fragmentAtual;
            // Configurar o clique do botão
            fragmentRegistrarViagem.configurarBotao1(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mudarFragmento(new FragmentRegistrarViagem());
                }
            });

            FragmentViagens fragmentDadosViagem = (FragmentViagens) fragmentAtual;
            fragmentDadosViagem.configurarBotao2(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mudarFragmento(new FragmentDadosDaViagem());
                }
            });


        } else {
            // Se não estiver pronto, tentar novamente depois
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                configurarBotaoDoFragment();
            }, 50);
        }
    }


    private void mudarFragmento(Fragment fragmento) {
        FragmentManager gerenciadorFragmento = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = gerenciadorFragmento.beginTransaction();

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE);
        fragmentTransaction.replace(R.id.frame_layout, fragmento, "current_fragment");
        fragmentTransaction.commitNow(); // Mudança aqui

        // Configurar imediatamente se for FragmentViagens
        if (fragmento instanceof FragmentViagens) {
            configurarBotaoDoFragment();
        }
    }
}