package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder> {

    private List<Materia> ListasMaterias;

    public MateriaAdapter(List<Materia> ListasMaterias) {
        this.ListasMaterias = ListasMaterias;
    }

    @Override
    public MateriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.materia_item, parent, false);
        return new MateriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MateriaViewHolder holder, int position) {
        Materia materia = ListasMaterias.get(position);
        holder.tvMateriaNome.setText(materia.getName());
        holder.tvMateriaDescricao.setText(materia.getDescription());
    }

    @Override
    public int getItemCount() {
        return ListasMaterias.size();
    }

    public class MateriaViewHolder extends RecyclerView.ViewHolder {
        TextView tvMateriaNome;
        TextView tvMateriaDescricao;

        public MateriaViewHolder(View itemView) {
            super(itemView);
            tvMateriaNome = itemView.findViewById(R.id.tvMateriaNome);
            tvMateriaDescricao = itemView.findViewById(R.id.tvMateriaDescricao);
        }
    }
}
