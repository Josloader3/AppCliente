package com.cibertec.appcliente.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cibertec.appcliente.R;

public class EventoDetalleActivity extends AppCompatActivity {

    private int idEvento;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_detalle);

        idEvento  = getIntent().getExtras().getInt("idEvento",0);
    }
}
