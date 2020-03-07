package com.cibertec.appcliente.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.cibertec.appcliente.R;
import com.cibertec.appcliente.database.AppDatabase;
import com.cibertec.appcliente.database.LoginDao;
import com.cibertec.appcliente.modelo.Login;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "MAIN_ACTIVITY";
    private final int DURACION_SPLASH= 3000;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.mContext = this;
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                verificarLoginPrevio();
            }
        },DURACION_SPLASH);

    }

    private void verificarLoginPrevio(){
        final LoginDao loginDao = AppDatabase.getDatabase(mContext).loginDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Login login = loginDao.getLastLogin();
                if(login != null){
                    //RECUPERAR USUARIO A PARTIR DE RETROFIT CON EL CORREO DEL LOGIN GUARDADO
                    openMenu();
                } else {
                    openLogin();
                }
            }
        }).start();
    }

    private void openLogin(){
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void openMenu(){
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
