package com.cibertec.appcliente.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cibertec.appcliente.api.ApiClient;
import com.cibertec.appcliente.interfaces.EventoService;
import com.cibertec.appcliente.adapters.ListaEventosAdapter;
import com.cibertec.appcliente.R;
import com.cibertec.appcliente.modelo.Evento;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventosFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListaEventosAdapter listaEventosAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventos, container, false);

        recyclerView = view.findViewById(R.id.recycler_eventos);
        listaEventosAdapter = new ListaEventosAdapter(getActivity());
        recyclerView.setAdapter(listaEventosAdapter);
        LinearLayoutManager linearManager = new LinearLayoutManager(getActivity()); //
        recyclerView.setLayoutManager(linearManager);

        obtenerDatos();

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void obtenerDatos() {

        EventoService eventoService = ApiClient.getApiClient()
                .create(EventoService.class);
        Call<List<Evento>> eventosRespuestaCall = eventoService.obtenerListaEventos();

        eventosRespuestaCall.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                if(response.isSuccessful()){

                    List<Evento> eventosRespuesta = response.body();
                    // ArrayList<EventosModelo> listaeventos = eventosRespuesta.getResults();

                    listaEventosAdapter.adicionarListaEventos(eventosRespuesta);
                    listaEventosAdapter.notifyDataSetChanged();
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });
    }
}
