package com.cibertec.appcliente.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.cibertec.appcliente.R;
import com.cibertec.appcliente.database.AppDatabase;
import com.cibertec.appcliente.database.LoginDao;
import com.cibertec.appcliente.modelo.Login;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "LOGIN_ACTIVITY";

    private EditText etEmailLogin, etPasswordLogin;
    private Button btnLogin;
    private TextView tvRegister;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mContext = this;
        inicializarControles();
    }

    private void inicializarControles() {
        etEmailLogin=findViewById(R.id.login_activity_etEmailLogin);
        etPasswordLogin=findViewById(R.id.login_activity_etPasswordLogin);
        tvRegister = findViewById(R.id.login_activity_tvRegister);
        btnLogin=findViewById(R.id.login_activity_btnLogin);

        tvRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_activity_tvRegister:
                openRegistro();
                break;
            case R.id.login_activity_btnLogin:
                validarLogin();
                break;
        }
    }

    private void validarLogin() {
        String email = etEmailLogin.getText().toString();
        String password = etPasswordLogin.getText().toString();
        if(!email.trim().equals("")){
            if(!password.trim().equals("")){
                final Login login = new Login();
                login.setEmail(email);
                login.setEmail(password);

                //ENVIAR OBJETO POR RETROFIT PARA VALIDAR POR API REST
                if(email.equals("admin") && password.equals("admin")){
                    final LoginDao loginDao = AppDatabase.getDatabase(mContext).loginDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loginDao.insertar(login);
                            openMenu();
                        }
                    }).start();
                } else {
                    Toast.makeText(mContext, "Usuario incorrecto", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(mContext, "Ingrese contraseña", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(mContext, "Ingrese correo", Toast.LENGTH_LONG).show();
        }
    }

    private void openRegistro() {
        /*Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(intent);
        finish();*/
    }

    private void openMenu(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
