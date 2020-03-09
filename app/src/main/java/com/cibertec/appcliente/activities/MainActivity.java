package com.cibertec.appcliente.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.cibertec.appcliente.R;
import com.cibertec.appcliente.fragments.CursosFragment;
import com.cibertec.appcliente.fragments.EventosFragment;
import com.cibertec.appcliente.fragments.UbicanosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.evento);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EventosFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_eventos);
        }
    }
    //onBackPressed() => Metodo para el Menu Navigation view
    public void onBackPressed(){
        if( drawer.isDrawerOpen(GravityCompat.START) ){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_eventos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EventosFragment()).commit();
                toolbar.setTitle(R.string.evento);
                break;
            case R.id.nav_cursos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CursosFragment()).commit();
                toolbar.setTitle(R.string.cursos);
                break;
            case R.id.nav_mapa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UbicanosFragment()).commit();
                toolbar.setTitle(R.string.ubicanos);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
