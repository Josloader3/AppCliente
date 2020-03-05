package com.cibertec.appcliente.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cibertec.appcliente.modelo.Login;

@Dao
public interface LoginDao {
    @Query("SELECT * from login_table LIMIT 1")
    Login getLastLogin();

    @Insert
    long insertar(Login login);

    @Update
    int actualizar(Login login);

    @Delete
    int eliminar(Login login);
}
