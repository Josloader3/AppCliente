package com.cibertec.appcliente;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class EventoDetalleActivity extends AppCompatActivity {

    private int idEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_detalle);

        idEvento  = getIntent().getExtras().getInt("idEvento",0);
    }
}