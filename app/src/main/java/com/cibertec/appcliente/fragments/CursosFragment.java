package com.cibertec.appcliente.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cibertec.appcliente.api.ApiClient;
import com.cibertec.appcliente.interfaces.CursoService;
import com.cibertec.appcliente.R;
import com.cibertec.appcliente.adapters.ListaCursosAdapter;
import com.cibertec.appcliente.modelo.Curso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursosFragment extends Fragment {
    View v;
    private RecyclerView myrecyclerView;
    private ArrayList<Curso> lstCursos =new ArrayList<>();
    private ListaCursosAdapter listaCursosAdapter;


    public CursosFragment() {
    }
    @NonNull
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.fragment_cursos, container, false);
        myrecyclerView = v.findViewById(R.id.recyclerView_cursos);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;

    }

    private void getServices() {
        CursoService cursoService = ApiClient.getApiClient()
                .create(CursoService.class);
        Call<List<Curso>> call = cursoService.getPosts();

        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                assert response.body() != null;
                lstCursos=new ArrayList<>(response.body());


                listaCursosAdapter =new ListaCursosAdapter(getActivity(),lstCursos);
                myrecyclerView.setAdapter(listaCursosAdapter);
                //Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getServices();
    }
}
