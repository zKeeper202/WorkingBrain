package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvMateriasDestacadas;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvBanner = findViewById(R.id.tvBanner);
        TextView tvMateriasDestacadas= findViewById(R.id.tvMateriasDestacadas);
        rvMateriasDestacadas = findViewById(R.id.rvMateriasDestacadas);
        TextView tvProgress = findViewById(R.id.tvProgress);
        progressBar = findViewById(R.id.progressBar);
        Button btnMyCourses = findViewById(R.id.btnMinhasMaterias);
        Button btnNews = findViewById(R.id.btnNovidades);
        Button btnSettings = findViewById(R.id.btnConfigs);

        // Configurar o RecyclerView para materias em destaque
        rvMateriasDestacadas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Configurar o Adapter com dados de exemplo
        MateriaAdapter adapter = new MateriaAdapter(getExemplosMaterias());
        rvMateriasDestacadas.setAdapter(adapter);

        // Configurar botões de navegação
        btnMyCourses.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MinhasMateriasActivity.class);
            startActivity(intent);
        });

        btnNews.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, NovidadesActivity.class);
            startActivity(intent);
        });

        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ConfiguracoesActivity.class);
            startActivity(intent);
        });
    }

    // Método para fornecer dados de exemplo para o RecyclerView
    private List<Materia> getExemplosMaterias() {
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Português", "Ora pois, quero comer bacalhau com punheta"));
        materias.add(new Materia("Matemática", "7 com 7 é 14 + 7 = 21"));
        // Adicionar mais cursos
        return materias;
    }
}
