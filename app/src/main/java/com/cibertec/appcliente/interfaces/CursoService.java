package com.cibertec.appcliente.interfaces;

import com.cibertec.appcliente.modelo.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CursoService {
    @GET("evento")
    Call<List<Curso>> getPosts();


}