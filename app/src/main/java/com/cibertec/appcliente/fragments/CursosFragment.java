package com.cibertec.appcliente.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cibertec.appcliente.ClientApi;
import com.cibertec.appcliente.Cursos;
import com.cibertec.appcliente.R;
import com.cibertec.appcliente.RecyclerViewAdapterCurso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CursosFragment extends Fragment {
    View v;
    private RecyclerView myrecyclerView;
    private ArrayList<Cursos> lstCursos =new ArrayList<>();
    private RecyclerViewAdapterCurso recyclerViewAdapterCurso;


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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.codigowebsite.app/cibertecapp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClientApi clientApi = retrofit.create(ClientApi.class);
        Call<List<Cursos>> call = clientApi.getPosts();

        call.enqueue(new Callback<List<Cursos>>() {
            @Override
            public void onResponse(Call<List<Cursos>> call, Response<List<Cursos>> response) {
                assert response.body() != null;
                lstCursos=new ArrayList<>(response.body());


                recyclerViewAdapterCurso=new RecyclerViewAdapterCurso(getActivity(),lstCursos);
                myrecyclerView.setAdapter(recyclerViewAdapterCurso);
                //Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Cursos>> call, Throwable t) {
                //Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getServices();
    }

}
