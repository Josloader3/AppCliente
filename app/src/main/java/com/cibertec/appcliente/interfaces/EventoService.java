package com.cibertec.appcliente.interfaces;

import com.cibertec.appcliente.modelo.Evento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventoService {

    @GET("evento")
    Call<List<Evento>> obtenerListaEventos();
    //Call<EventosRespuesta> obtenerListaEventos();

}
