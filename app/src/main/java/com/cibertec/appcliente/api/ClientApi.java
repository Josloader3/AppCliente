package com.cibertec.appcliente.api;

import com.cibertec.appcliente.modelo.Cursos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientApi {
    @GET("evento")
    Call<List<Cursos>> getPosts();


}