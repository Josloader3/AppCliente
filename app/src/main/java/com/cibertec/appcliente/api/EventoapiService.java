package com.cibertec.appcliente.api;

import com.cibertec.appcliente.modelo.EventosModelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventoapiService {

    @GET("evento")
    Call<List<EventosModelo>> obtenerListaEventos();
    //Call<EventosRespuesta> obtenerListaEventos();

}
