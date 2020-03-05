package com.cibertec.appcliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cibertec.appcliente.activities.LoginActivity;
import com.cibertec.appcliente.database.AppDatabase;
import com.cibertec.appcliente.database.LoginDao;
import com.cibertec.appcliente.modelo.Login;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN_ACTIVITY";

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mContext = this;
        verificarLoginPrevio();
    }

    private void verificarLoginPrevio(){
        final LoginDao loginDao = AppDatabase.getDatabase(mContext).loginDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Login login = loginDao.getLastLogin();
                if(login != null){
                    //RECUPERAR USUARIO A PARTIR DE RETROFIT CON EL CORREO DEL LOGIN GUARDADO
                    //openMenu();
                } else {
                    openLogin();
                }
            }
        }).start();
    }

    private void openLogin(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    /*private void openMenu(){
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }*/

}
