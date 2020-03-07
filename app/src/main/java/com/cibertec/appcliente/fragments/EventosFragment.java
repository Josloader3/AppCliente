package com.cibertec.appcliente.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cibertec.appcliente.api.EventoapiService;
import com.cibertec.appcliente.adapters.ListaEventosAdapter;
import com.cibertec.appcliente.R;
import com.cibertec.appcliente.modelo.EventosModelo;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class EventosFragment extends Fragment {

    private Retrofit retrofit;

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

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.codigowebsite.app/cibertecapp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void obtenerDatos() {
        EventoapiService service = retrofit.create(EventoapiService.class);
        Call<List<EventosModelo>> eventosRespuestaCall = service.obtenerListaEventos();

        eventosRespuestaCall.enqueue(new Callback<List<EventosModelo>>() {
            @Override
            public void onResponse(Call<List<EventosModelo>> call, Response<List<EventosModelo>> response) {
                if(response.isSuccessful()){

                    List<EventosModelo> eventosRespuesta = response.body();
                    // ArrayList<EventosModelo> listaeventos = eventosRespuesta.getResults();

                    listaEventosAdapter.adicionarListaEventos(eventosRespuesta);
                    listaEventosAdapter.notifyDataSetChanged();
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<EventosModelo>> call, Throwable t) {

            }
        });
    }
}
