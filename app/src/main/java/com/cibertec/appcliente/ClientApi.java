package com.cibertec.appcliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientApi {
    @GET("evento")
    Call<List<Cursos>> getPosts();


}