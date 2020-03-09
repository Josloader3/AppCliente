package com.cibertec.appcliente.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cibertec.appcliente.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CursoDetalleActivity extends AppCompatActivity {
    private Toolbar toolbar;
    TextView tv_Title;
    ImageView img_banner;
    TextView tv_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_detalle);
        tv_Title = findViewById(R.id.tv_Title);
        tv_description = findViewById(R.id.tv_description);
        img_banner = findViewById(R.id.img_banner);

        String headerCode = "";
        String descripcion = "";
        //int img = 0;
        Bundle extras = getIntent().getExtras();
        if(extras != null ){
            headerCode = extras.getString("headerCode");
            descripcion = extras.getString("description");
            //img = extras.getInt("img");
        }
        tv_Title.setText(headerCode);
        tv_description.setText(descripcion);
        //img_banner.setImageResource(img);





    }
}
