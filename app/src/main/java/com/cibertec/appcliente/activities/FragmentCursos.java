package com.cibertec.appcliente.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cibertec.appcliente.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentCursos extends Fragment {

    View v;
    private RecyclerView myrecyclerView;
    private List<Cursos> lstCursos;

    public FragmentCursos() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v  = inflater.inflate(R.layout.cursos_fragment, container,false);
        myrecyclerView = v.findViewById(R.id.recyclerView_cursos);
        RecyclerViewAdapterCurso recyclerViewAdapterCurso = new RecyclerViewAdapterCurso(getContext(), lstCursos);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapterCurso);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstCursos = new ArrayList<>();
        lstCursos.add(new Cursos("Curso de Informatica", "Serás un experto en la computación e informática enfocado en la tecnología como herramienta aplicada al mercado laboral.", R.drawable.cienciasdelacomputacion));
        lstCursos.add(new Cursos("Curso de Informatica2", "Serás un experto en la computación e informática enfocado en la tecnología como herramienta aplicada al mercado laboral.", R.drawable.cienciasdelacomputacion));
        lstCursos.add(new Cursos("Curso de Informatica3", "Serás un experto en la computación e informática enfocado en la tecnología como herramienta aplicada al mercado laboral.", R.drawable.cienciasdelacomputacion));
        lstCursos.add(new Cursos("Curso de Informatica4", "Serás un experto en la computación e informática enfocado en la tecnología como herramienta aplicada al mercado laboral.", R.drawable.cienciasdelacomputacion));

    }
}
