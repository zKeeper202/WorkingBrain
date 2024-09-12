package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MinhasMateriasActivity extends AppCompatActivity {

    private RecyclerView rvMinhasMaterias = findViewById(R.id.rvMinhasMaterias);
    private List<Materia> minhasMaterias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_materias);

        // Criar dados de exemplo
        minhasMaterias = getMateriasInscritos();

        // Configurar o RecyclerView
        rvMinhasMaterias.setLayoutManager(new LinearLayoutManager(this));
        MateriaAdapter adapter = new MateriaAdapter(minhasMaterias);
        rvMinhasMaterias.setAdapter(adapter);
    }

    // Simular lista de materias inscritas
    private List<Materia> getMateriasInscritos() {
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Matéria de Mobile", "Exemplo", 75));
        materias.add(new Materia("Matéria de JG", "Exemplo", 50));
        // Adicionar mais matérias conforme necessário
        return materias;
    }
}
