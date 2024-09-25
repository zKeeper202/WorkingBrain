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
        TextView tvMateriasDestacadas = findViewById(R.id.tvMateriasDestacadas);
        rvMateriasDestacadas = findViewById(R.id.rvMateriasDestacadas);
        TextView tvProgress = findViewById(R.id.tvProgress);
        progressBar = findViewById(R.id.progressBar);
        Button btnMyCourses = findViewById(R.id.btnMinhasMaterias);
        Button btnConfigs = findViewById(R.id.btnConfigs);
        /*Button btnNews = findViewById(R.id.btnNovidades);*/

        // Configurar o RecyclerView para materias em destaque
        rvMateriasDestacadas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Configurar o Adapter com dados de exemplo
        MateriaAdapter adapter = new MateriaAdapter(getExemplosMaterias());
        rvMateriasDestacadas.setAdapter(adapter);

        // Configurar botões de navegação
        btnMyCourses.setOnClickListener(v -> {
            Intent HMM = new Intent(HomeActivity.this, MinhasMateriasActivity.class);
            startActivity(HMM);
        });

        /* Talvez exista essa parte...
        btnNews.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, NovidadesActivity.class);
            startActivity(intent);
        });*/

        btnConfigs.setOnClickListener(v -> {
            Intent HC = new Intent(HomeActivity.this, ConfiguracoesActivity.class);
            startActivity(HC);
        });
    }

    // Método para fornecer dados de exemplo para o RecyclerView
    private List<Materia> getExemplosMaterias() {
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Português", "Ora pois, iremos roubar o Brasil", 75));
        materias.add(new Materia("Matemática", "7 com 7 é 14 + 7 = 21", 75));
        // Adicionar mais cursos
        return materias;
    }
}
