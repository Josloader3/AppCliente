package api;


import com.cibertec.appcliente.data.Cursos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClientApi {
    @GET("evento")
    Call<List<Cursos>> getPosts();


}

